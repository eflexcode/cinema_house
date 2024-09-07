package com.ifeanyi.cinema_house.user.service;

import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User create(UserModel userModel) {

        User user = new User();

        BeanUtils.copyProperties(userModel, user);
        user.setPassword(passwordEncoder.encode(userModel.getPassword()));

        return repository.save(user);
    }

    @Override
    public User get(String id) throws NotFoundExceptionHandler {
        return repository.findById(id).orElseThrow(() -> new NotFoundExceptionHandler("No user found with id: " + id));
    }

    @Override
    public User update(String id, UserModel userModel) throws NotFoundExceptionHandler {

        User user = get(id);
        user.setEmail(userModel.getEmail() != null ? userModel.getEmail() : user.getEmail());
        user.setName(userModel.getName() != null ? userModel.getName() : user.getName());
        user.setPassword(userModel.getPassword() != null ? userModel.getPassword() : user.getPassword());

        return repository.save(user);
    }

    @Override
    public void delete(String id) throws NotFoundExceptionHandler {
        repository.delete(get(id));
    }

    @Override
    public User getLoggedInUser() throws NotFoundExceptionHandler {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userId = authentication.getName();
        return get(userId);
    }

    @Override
    public Token login(Login login) throws NotFoundExceptionHandler {

       User user =  getByEmail(login.getEmail());

       if(passwordEncoder.matches(login.getPassword(), user.getPassword())) {
           
       }
        return null;
    }

    @Override
    public User getByEmail(String email) throws NotFoundExceptionHandler {
        return repository.findByEmail(email).orElseThrow(() -> new NotFoundExceptionHandler("No user found with email: " + email));
    }
}
