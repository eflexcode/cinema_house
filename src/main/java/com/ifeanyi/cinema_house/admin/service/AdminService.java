package com.ifeanyi.cinema_house.admin.service;

import com.ifeanyi.cinema_house.admin.entity.Admin;
import com.ifeanyi.cinema_house.admin.model.AdminModel;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;

public interface AdminService {

    Admin create(AdminModel adminModel);
    Admin get(String id) throws NotFoundExceptionHandler;
    Admin update(String id,AdminModel adminModel) throws NotFoundExceptionHandler;
    void delete(String id) throws NotFoundExceptionHandler;

}
