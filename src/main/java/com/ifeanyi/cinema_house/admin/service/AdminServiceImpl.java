//package com.ifeanyi.cinema_house.admin.service;
//
//import com.ifeanyi.cinema_house.admin.entity.Admin;
//import com.ifeanyi.cinema_house.admin.model.AdminModel;
//import com.ifeanyi.cinema_house.admin.repository.AdminRepo;
//import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.BeanUtils;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AdminServiceImpl implements AdminService{
//
//    private final AdminRepo adminRepo;
//
//    @Override
//    public Admin create(AdminModel adminModel) {
//
//        Admin admin = new Admin();
//        BeanUtils.copyProperties(adminModel,admin);
//
//        return adminRepo.save(admin);
//    }
//
//    @Override
//    public Admin get(String id) throws NotFoundExceptionHandler {
//        return adminRepo.findById(id).orElseThrow(()-> new NotFoundExceptionHandler("No admin found with id: "+id));
//    }
//
//    @Override
//    public Admin update(String id, AdminModel adminModel) throws NotFoundExceptionHandler {
//
//        Admin admin = get(id);
//        admin.setName(adminModel.getName() != null ? adminModel.getName() : admin.getName());
//
//        return adminRepo.save(admin);
//    }
//
//    @Override
//    public void delete(String id) throws NotFoundExceptionHandler {
//        adminRepo.delete(get(id));
//    }
//}
