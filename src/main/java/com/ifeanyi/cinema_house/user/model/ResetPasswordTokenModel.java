package com.ifeanyi.cinema_house.user.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class ResetPasswordTokenModel {

    private String token;
    private Date ExpireTime;
    private String userId;

}
