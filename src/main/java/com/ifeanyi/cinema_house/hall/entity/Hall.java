package com.ifeanyi.cinema_house.hall.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Hall {

    private String id;
    private Integer hallNumber;
    private Integer availableSeat;
    private Integer soldSeat;
    private String showingId;
    private String updatedByAdmin;
    private String createdByAdmin;

}
