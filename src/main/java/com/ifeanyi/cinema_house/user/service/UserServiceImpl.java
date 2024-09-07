package com.ifeanyi.cinema_house.user.service;

import com.ifeanyi.cinema_house.auth.service.JwtService;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.exception.UnauthorizedException;
import com.ifeanyi.cinema_house.user.entity.Login;
import com.ifeanyi.cinema_house.user.entity.Token;
import com.ifeanyi.cinema_house.user.entity.User;
import com.ifeanyi.cinema_house.user.model.UserModel;
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

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    @Override
    public User create(UserModel userModel) {

        User user = new User();

        BeanUtils.copyProperties(userModel, user);
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        return repository.save(user);
    }

    @Override
    public User get(String id) throws NotFoundException {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("No user found with id: " + id));
    }

    @Override
    public User update(String id, UserModel userModel) throws NotFoundException {

        User user = get(id);
        user.setEmail(userModel.getEmail() != null ? userModel.getEmail() : user.getEmail());
        user.setName(userModel.getName() != null ? userModel.getName() : user.getName());
        user.setPassword(userModel.getPassword() != null ? userModel.getPassword() : user.getPassword());

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
    public Token login(Login login) throws NotFoundException, UnauthorizedException {

        User user;

        try {
             user =  getByEmail(login.getEmail());
        }catch (NotFoundException foundException){
            throw new UnauthorizedException("Invalid email or password");
        }

       if(passwordEncoder.matches(login.getPassword(), user.getPassword())) {
           return new Token(jwtService.generateToken(user.getId()));
       }
      throw new UnauthorizedException("Invalid email or password");
    }

    @Override
    public User getByEmail(String email) throws NotFoundException {
        return repository.findByEmail(email).orElseThrow(() -> new NotFoundException("No user found with email: " + email));
    }
}
