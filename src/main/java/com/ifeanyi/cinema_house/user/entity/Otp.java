package com.ifeanyi.cinema_house.user.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.annotation.Collation;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Otp {

    private String id;// id is user id to avoid duplicate
    private Integer otp;
    private Date ExpireTime;
//    private String userId;

}
