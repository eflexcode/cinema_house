//package com.ifeanyi.cinema_house.admin.controller;
//
//import com.ifeanyi.cinema_house.admin.entity.Admin;
//import com.ifeanyi.cinema_house.admin.model.AdminModel;
//import com.ifeanyi.cinema_house.admin.service.AdminService;
//import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/admin/")
//public class AdminController {
//
//    private final AdminService adminService;
//
//    @PostMapping
//    public Admin create(@RequestBody AdminModel adminModel){
//        return adminService.create(adminModel);
//    }
//
//    @PutMapping("{id}")
//    public Admin update(@PathVariable String id,@RequestBody AdminModel adminModel) throws NotFoundExceptionHandler {
//        return adminService.update(id,adminModel);
//    }
//
//    @GetMapping("{id}")
//    public Admin get(@PathVariable String id) throws NotFoundExceptionHandler {
//        return adminService.get(id);
//    }
//
//    @DeleteMapping("{id}")
//    public void delete(@PathVariable String id) throws NotFoundExceptionHandler {
//        adminService.delete(id);
//    }
//
//}
