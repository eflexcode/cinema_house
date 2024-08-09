package com.ifeanyi.cinema_house.movie.service;

import com.ifeanyi.cinema_house.admin.entity.Admin;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.movie.entity.Movie;
import com.ifeanyi.cinema_house.movie.model.MovieModel;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService{

    @Override
    public Movie create(MovieModel movieModel) {
        return null;
    }

    @Override
    public Movie get(String id) throws NotFoundExceptionHandler {
        return null;
    }

    @Override
    public Admin update(String id, MovieModel movieModel) throws NotFoundExceptionHandler {
        return null;
    }

    @Override
    public void delete(String id) throws NotFoundExceptionHandler {

    }

}
