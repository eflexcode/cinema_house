package com.ifeanyi.cinema_house.admin.service;

import com.ifeanyi.cinema_house.admin.entity.Admin;
import com.ifeanyi.cinema_house.admin.model.AdminModel;

public interface AdminService {

    Admin create(AdminModel adminModel);
    Admin get(String id);
    Admin update(String id,AdminModel adminModel);
    Admin delete(String id);

}
