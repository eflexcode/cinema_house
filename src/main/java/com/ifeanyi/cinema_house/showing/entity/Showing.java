package com.ifeanyi.cinema_house.showing.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Showing {
    private String id;
    private String moveId;
    private Date showingTime;
    private String hallId;
    private String updatedByAdmin;
    private String createdByAdmin;
}
