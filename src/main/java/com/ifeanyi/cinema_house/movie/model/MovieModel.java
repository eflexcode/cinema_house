package com.ifeanyi.cinema_house.movie.model;

import com.ifeanyi.cinema_house.cast.entity.Cast;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class MovieModel {
    private String title;
    private String description;
    private String shortDescription;
    private String genres;
    private Date releaseDate;
    private Integer likeCount;
    private Integer disLikeCount;
    private String updatedByAdmin;
    private String createdByAdmin;
    private List<String> castIds;
    private String verticalImageUrl;
    private String horizontalImageUrl;
}
