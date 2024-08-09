package com.ifeanyi.cinema_house.movie.service;

import com.ifeanyi.cinema_house.admin.entity.Admin;
import com.ifeanyi.cinema_house.admin.model.AdminModel;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.movie.entity.Movie;
import com.ifeanyi.cinema_house.movie.model.MovieModel;

public interface MovieService {

    Movie create(MovieModel movieModel);
    Movie get(String id) throws NotFoundExceptionHandler;
    Admin update(String id,MovieModel movieModel) throws NotFoundExceptionHandler;
    void delete(String id) throws NotFoundExceptionHandler;

}
