package com.ifeanyi.cinema_house.ticket.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Ticket {

    private String id;
    private String HallId;
    private boolean used;
    private String ownerId;

}
