package com.ifeanyi.cinema_house.user.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class UserModel {

    private String name;
    private String email;
    private String password;

}
