package com.ifeanyi.cinema_house.user.service;

import com.ifeanyi.cinema_house.exception.*;
import com.ifeanyi.cinema_house.user.model.Login;
import com.ifeanyi.cinema_house.user.model.Token;
import com.ifeanyi.cinema_house.user.entity.User;
import com.ifeanyi.cinema_house.user.model.UserModel;

public interface UserService {

    User create(UserModel userModel) throws DuplicateException, BadRequestException;
    User get(String id) throws NotFoundException;
    User update(UserModel userModel) throws NotFoundException;
    void delete(String id) throws NotFoundException;
    User getLoggedInUser() throws NotFoundException;

    Token login(Login login) throws NotFoundException, UnauthorizedException, BadRequestException;
    User getByEmail(String email) throws NotFoundException;

    String generatePasswordResetToken(String id);
    String resetPassword(String resetPasswordId,String firstPassword,String secondPassword) throws ForbiddenException, BadRequestException, NotFoundException;

}
