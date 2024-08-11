package com.ifeanyi.cinema_house.cast.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
public class CastModel {

    private String name;
    private String description;
    private String imageUrl;
    private List<String> movieIds;
    private String updatedByAdmin;
    private String createdByAdmin;

}
