package com.ifeanyi.cinema_house.movie.entity;

import com.ifeanyi.cinema_house.cast.entity.Cast;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document
@Data
public class Movie {
    private String id;
    private String title;
    private String description;
    private String shortDescription;
    private String genres;
    private Date releaseDate;
    private Integer likeCount;
    private Integer disLikeCount;
    private List<String> castIds;
    private String verticalImageUrl;
    private String horizontalImageUrl;
    private String createdByAdmin;
    private String updatedByAdmin;
    private Date createdAt;
    private Date updatedAt;
}
