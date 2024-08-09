package com.ifeanyi.cinema_house.cast.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
public class Cast {

    private String id;
    private String name;
    private String description;
    private String imageUrl;
    private List<String> movieIds;

}
