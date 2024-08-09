package com.ifeanyi.cinema_house.admin.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Admin {

    @Id
    private String id;
    private String name;

}
