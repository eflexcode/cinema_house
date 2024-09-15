package com.ifeanyi.cinema_house.user.controller;

import com.ifeanyi.cinema_house.exception.*;
import com.ifeanyi.cinema_house.user.model.*;
import com.ifeanyi.cinema_house.user.entity.User;
import com.ifeanyi.cinema_house.user.service.OtpService;
import com.ifeanyi.cinema_house.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final OtpService otpService;

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

        try {
            userModel.setEnable(null);
            userModel.setPassword(null);
        } catch (Exception ignored) {
            // make sure user cant manually update user enabled
        }

        return userService.update(id, userModel);
    }

    @PostMapping("/api/user/otp/generate/{userId}")
    public String generateOtp(@PathVariable String userId) {
        return otpService.generateOtp(userId);
    }

    @PostMapping("/api/user/otp/verify}")
    public String verifyOtp(@RequestBody VerifyOtp opt) throws NotFoundException, GoneException {
        return otpService.verifyOtp(opt.getOtp());
    }

    @PostMapping("/api/user/password/send_reset/{id}")
    public String sendReset(@PathVariable String id) {
        return userService.generatePasswordResetToken(id);
    }

    @PostMapping("/api/user/password/reset/")
    public String reset(@RequestBody VerifyPassword verifyPassword) throws ForbiddenException, BadRequestException, NotFoundException {
        return userService.resetPassword(verifyPassword.getResetPasswordId(), verifyPassword.getFirstPassword(), verifyPassword.getSecondPassword());
    }

    @DeleteMapping("/api/user/{id}")
    public void delete(@PathVariable String id) throws NotFoundException {
        userService.delete(id);
    }

}
