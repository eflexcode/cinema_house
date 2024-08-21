package com.ifeanyi.cinema_house.ticket.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
public class TicketModel {

    private String HallId;
    private String ownerId;
    private boolean used;

}
