package com.ifeanyi.cinema_house.user.service;

import com.ifeanyi.cinema_house.exception.BadRequestException;
import com.ifeanyi.cinema_house.exception.DuplicateException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.exception.UnauthorizedException;
import com.ifeanyi.cinema_house.user.entity.Login;
import com.ifeanyi.cinema_house.user.entity.Token;
import com.ifeanyi.cinema_house.user.entity.User;
import com.ifeanyi.cinema_house.user.model.UserModel;

public interface UserService {

    User create(UserModel userModel) throws DuplicateException, BadRequestException;
    User get(String id) throws NotFoundException;
    User update(String id,UserModel userModel) throws NotFoundException;
    void delete(String id) throws NotFoundException;
    User getLoggedInUser() throws NotFoundException;

    Token login(Login login) throws NotFoundException, UnauthorizedException;
    User getByEmail(String email) throws NotFoundException;

}
