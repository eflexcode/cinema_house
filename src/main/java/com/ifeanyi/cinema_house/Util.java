package com.ifeanyi.cinema_house;

import com.ifeanyi.cinema_house.exception.ForbiddenExceptionHandler;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.user.entity.User;
import com.ifeanyi.cinema_house.user.role.UserRole;
import com.ifeanyi.cinema_house.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Util {


    public static void isUserAdmin(String adminId, UserService userService) throws ForbiddenExceptionHandler, NotFoundExceptionHandler {
        User user = userService.get(adminId);
        if (user.getUserType() != UserRole.ADMIN) {
            throw new ForbiddenExceptionHandler("User is not admin");
        }
    }

}
