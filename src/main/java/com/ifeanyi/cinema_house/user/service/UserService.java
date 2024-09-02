package com.ifeanyi.cinema_house.user.service;

import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.user.entity.User;
import com.ifeanyi.cinema_house.user.model.UserModel;

public interface UserService {

    User create(UserModel userModel);
    User get(String id) throws NotFoundExceptionHandler;
    User update(String id,UserModel userModel) throws NotFoundExceptionHandler;
    void delete(String id) throws NotFoundExceptionHandler;
    User getLoggedInUser() throws NotFoundExceptionHandler;

}
