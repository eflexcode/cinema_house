package com.ifeanyi.cinema_house.admin.service;

import com.ifeanyi.cinema_house.admin.entity.Admin;
import com.ifeanyi.cinema_house.admin.model.AdminModel;
import com.ifeanyi.cinema_house.admin.repository.AdminRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{

    private final AdminRepo adminRepo;

    @Override
    public Admin create(AdminModel adminModel) {

        Admin admin = new Admin();
        BeanUtils.copyProperties(adminModel,admin);

        return adminRepo.save(admin);
    }

    @Override
    public Admin get(String id) {
        return adminRepo.findById(id);
    }

    @Override
    public Admin update(String id, AdminModel adminModel) {
        return null;
    }

    @Override
    public Admin delete(String id) {
        return null;
    }
}
