package com.ifeanyi.cinema_house.user.controller;

import com.ifeanyi.cinema_house.exception.BadRequestException;
import com.ifeanyi.cinema_house.exception.DuplicateException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.exception.UnauthorizedException;
import com.ifeanyi.cinema_house.user.model.Login;
import com.ifeanyi.cinema_house.user.model.Token;
import com.ifeanyi.cinema_house.user.entity.User;
import com.ifeanyi.cinema_house.user.model.UserModel;
import com.ifeanyi.cinema_house.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    User user = null;

    @PostMapping("/api/user/create")
    public User create(@RequestBody UserModel userModel) throws DuplicateException, BadRequestException {
        return userService.create(userModel);
    }

    @PostMapping("/api/user/login")
    public Token login(@RequestBody Login login) throws NotFoundException, UnauthorizedException, BadRequestException {
        return userService.login(login);
    }

    @GetMapping("/api/user/{id}")
    public User get(@PathVariable String id) throws NotFoundException {
//        user.getEmail();
        return userService.get(id);
    }

    @PutMapping("/api/user/{id}")
    public User update(@PathVariable String id, @RequestBody UserModel userModel) throws NotFoundException {
        return userService.update(id, userModel);
    }

    @DeleteMapping("/api/user/{id}")
    public void delete(@PathVariable String id) throws NotFoundException {
        userService.delete(id);
    }

}
