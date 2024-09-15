package com.ifeanyi.cinema_house.user.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class ResetPasswordToken {

    private String id;
    private String token;
    private Date ExpireTime;
    private String userId;

}
