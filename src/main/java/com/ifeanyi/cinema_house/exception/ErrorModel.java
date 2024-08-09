package com.ifeanyi.cinema_house.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorModel {
    private String message;
    private Date timestamp;
    private Integer statusCode;
}
