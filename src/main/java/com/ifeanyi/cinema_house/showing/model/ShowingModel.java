package com.ifeanyi.cinema_house.showing.model;

import lombok.Data;

import java.util.Date;

@Data
public class ShowingModel {

    private String moveId;
    private Date showingTime;
    private String hallId;
    private String adminId;

}
