package com.ifeanyi.cinema_house.user.controller;

import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.user.entity.User;
import com.ifeanyi.cinema_house.user.model.UserModel;
import com.ifeanyi.cinema_house.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/api/user/")
    public User create(@RequestBody UserModel userModel) {
        return userService.create(userModel);
    }

    @GetMapping("/api/user/{id}")
    public User get(@PathVariable String id) throws NotFoundExceptionHandler {
        return userService.get(id);
    }

    @PutMapping("/api/user/{id}")
    public User update(@PathVariable String id, @RequestBody UserModel userModel) throws NotFoundExceptionHandler {
        return userService.update(id, userModel);
    }

    @DeleteMapping("/api/user/{id}")
    public void delete(@PathVariable String id) throws NotFoundExceptionHandler {
        userService.delete(id);
    }

}
