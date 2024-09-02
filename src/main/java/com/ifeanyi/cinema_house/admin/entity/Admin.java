//package com.ifeanyi.cinema_house.admin.entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import java.util.Collection;
//import java.util.List;
//
//@Data
//@Document
//public class Admin extends UserDetails {
//
//    @Id
//    private String id;
//    private String name;
//    @JsonIgnore
//    private String password;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of();
//    }
//
//    @Override
//    public String getPassword() {
//        return "";
//    }
//
//    @Override
//    public String getUsername() {
//        return id;
//    }
//}
