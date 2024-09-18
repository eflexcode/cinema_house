package com.ifeanyi.cinema_house.user.controller;

import com.ifeanyi.cinema_house.exception.*;
import com.ifeanyi.cinema_house.user.model.*;
import com.ifeanyi.cinema_house.user.entity.User;
import com.ifeanyi.cinema_house.user.service.OtpService;
import com.ifeanyi.cinema_house.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final OtpService otpService;

    User user = null;

    @PostMapping("/api/auth/create")
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody UserModel userModel) throws DuplicateException, BadRequestException {
        return userService.create(userModel);
    }

    @PostMapping("/api/auth/login")
    public Token login(@RequestBody Login login) throws NotFoundException, UnauthorizedException, BadRequestException {
        return userService.login(login);
    }

    @GetMapping("/api/user/")
    public User get() throws NotFoundException {
        return userService.getLoggedInUser();
    }

    @PutMapping("/api/user")
    public User update(@RequestBody UserModel userModel) throws NotFoundException {

        try {
            userModel.setActivated(null);
            userModel.setPassword(null);
        } catch (Exception ignored) {
            // make sure user cant manually update user enabled
        }

        return userService.update(userModel);
    }

    @PostMapping("/api/auth/otp/generate")
    public String generateOtp(@RequestBody GeneratePasswordModel generatePasswordModel) {
        return otpService.generateOtp(generatePasswordModel.getUserId());
    }

    @PostMapping("/api/auth/otp/verify")
    public String verifyOtp(@RequestBody VerifyOtp opt) throws NotFoundException, GoneException {
        return otpService.verifyOtp(opt.getOtp());
    }

    @PostMapping("/api/auth/password/send_reset/{id}")
    public String sendReset(@PathVariable String id) {
        return userService.generatePasswordResetToken(id);
    }

    @PostMapping("/api/auth/password/reset/")
    public String reset(@RequestBody VerifyPassword verifyPassword) throws ForbiddenException, BadRequestException, NotFoundException {
        return userService.resetPassword(verifyPassword.getResetPasswordId(), verifyPassword.getFirstPassword(), verifyPassword.getSecondPassword());
    }

    @DeleteMapping("/api/user/{id}")
    public void delete(@PathVariable String id) throws NotFoundException {
        userService.delete(id);
    }

}
