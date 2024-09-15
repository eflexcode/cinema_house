package com.ifeanyi.cinema_house.user.model;

import lombok.Data;

@Data
public class VerifyPassword {
    private String resetPasswordId;
    private String firstPassword;
    private String secondPassword;
}
