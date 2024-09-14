package com.ifeanyi.cinema_house.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ifeanyi.cinema_house.user.role.UserRole;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Document
@Data
public class User  implements UserDetails {

    private String id;
    private String name;
    private String email;
    @JsonIgnore
    private String password;
    private UserRole userType;
    private Boolean enable;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        List<SimpleGrantedAuthority> authorityList  = new ArrayList<>();
        authorityList.add(new SimpleGrantedAuthority(userType.name()));

        return authorityList;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return id;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
