package com.ifeanyi.cinema_house.user.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class User {

    private String id;
    private String name;
    private String email;
    private String password;

}
