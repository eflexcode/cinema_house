package com.ifeanyi.cinema_house.hall.model;

import lombok.Data;

@Data
public class HallModel {

    private Integer hallNumber;
    private Integer availableSeat;
    private Integer soldSeat;
    private String showingId;
    private String updatedByAdmin;

}
