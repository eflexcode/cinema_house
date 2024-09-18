package com.ifeanyi.cinema_house.user.service;

import com.ifeanyi.cinema_house.auth.service.JwtService;
import com.ifeanyi.cinema_house.exception.*;
import com.ifeanyi.cinema_house.user.entity.ResetPasswordToken;
import com.ifeanyi.cinema_house.user.model.Login;
import com.ifeanyi.cinema_house.user.model.Token;
import com.ifeanyi.cinema_house.user.entity.User;
import com.ifeanyi.cinema_house.user.model.UserModel;
import com.ifeanyi.cinema_house.user.model.VerifyPassword;
import com.ifeanyi.cinema_house.user.repository.ResetPasswordRepository;
import com.ifeanyi.cinema_house.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final ResetPasswordRepository resetPasswordRepository;
//    private final AuthenticationManager authenticationManager;

    @Override
    public User create(UserModel userModel) throws DuplicateException, BadRequestException {

        if (userModel.getEmail() == null || userModel.getPassword() == null || userModel.getUserType() == null) {
            throw new BadRequestException("Semantic errors email, password and userType are required");
        }

        boolean present = repository.findByEmail(userModel.getEmail()).isPresent();

        if (present) {
            throw new DuplicateException("A user already exist with this email: " + userModel.getEmail());
        }

        if (userModel.getPassword().length() < 8) {
            throw new BadRequestException("Password minimum length is 8 characters");
        }

        String regexPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(userModel.getPassword());

        if (!matcher.matches()) {
            throw new BadRequestException("Password most contain number upper and lower case letter with special character");
        }

        User user = new User();

        BeanUtils.copyProperties(userModel, user);
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));
        user.setActivated(false);
//        user.setUserType(UserRole.USER);

        return repository.save(user);
    }

    @Override
    public User get(String id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No user found with id: " + id));
    }

    @Override
    public User update(String userId,UserModel userModel) throws NotFoundException {

        User user;

        if (userId == null){
            user = getLoggedInUser();
        }

         user = get(userId);
//        user.setEmail(userModel.getEmail() != null ? userModel.getEmail() : user.getEmail());
        user.setName(userModel.getName() != null ? userModel.getName() : user.getName());
        user.setPassword(userModel.getPassword() != null ? userModel.getPassword() : user.getPassword());
        user.setActivated(userModel.getActivated() != null ? userModel.getActivated() : user.getActivated());

        return repository.save(user);
    }

    @Override
    public void delete(String id) throws NotFoundException {
        repository.delete(get(id));
    }

    @Override
    public User getLoggedInUser() throws NotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        return get(userId);
    }

    @Override
    public String getLoggedInUserId() throws NotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @Override
    public Token login(Login login) throws NotFoundException, UnauthorizedException, BadRequestException {

//        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(),login.getPassword()));

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new BadRequestException("Semantic errors email and password are required");
        }

        User user;

        try {
            user = getByEmail(login.getEmail());
        } catch (NotFoundException foundException) {
            throw new UnauthorizedException("Invalid email or password");
        }

        if (passwordEncoder.matches(login.getPassword(), user.getPassword()) && user.getActivated()) {
            return new Token(jwtService.generateToken(user.getId()));
        }

        throw new UnauthorizedException("Invalid email or password");
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return repository.findByEmail(email).orElseThrow(() -> new NotFoundException("No user found with email: " + email));
    }

    @Override
    public String generatePasswordResetToken(String id) {

        ResetPasswordToken passwordToken = new ResetPasswordToken();
        passwordToken.setId(id);
        passwordToken.setExpireTime(new Date(System.currentTimeMillis() + 5 * 60000));
        passwordToken.setToken(UUID.randomUUID().toString());

        resetPasswordRepository.save(passwordToken);

        return "Password reset link have been sent to your email";
    }

    @Override
    public String resetPassword(VerifyPassword verifyPassword) throws ForbiddenException, BadRequestException, NotFoundException, GoneException {

        ResetPasswordToken passwordToken = resetPasswordRepository.findByToken(verifyPassword.getToken()).orElseThrow(() -> new ForbiddenException("Invalid reset token"));

        if (verifyPassword.getFirstPassword() == null || verifyPassword.getSecondPassword() == null) {
            throw new BadRequestException("first and second password required");
        }

        if (!verifyPassword.getFirstPassword().equals(verifyPassword.getSecondPassword())) {
            throw new BadRequestException("Password mismatch");
        }

        if (verifyPassword.getFirstPassword().length() < 8) {
            throw new BadRequestException("Password minimum length is 8 characters");
        }

        String regexPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$";

        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(verifyPassword.getFirstPassword());

        if (!matcher.matches()) {
            throw new BadRequestException("Password most contain number upper and lower case letter with special character");
        }

        if (new Date().after(passwordToken.getExpireTime())) {
            delete(passwordToken.getId());
            throw new GoneException("Password reset token expired");
        }

        String encodedPassword = passwordEncoder.encode(verifyPassword.getFirstPassword());

        UserModel userModel = new UserModel();
        userModel.setPassword(encodedPassword);

        update(passwordToken.getId(),userModel);

        resetPasswordRepository.deleteById(passwordToken.getId());

        return "Password reset successful you can login now";
    }
}
