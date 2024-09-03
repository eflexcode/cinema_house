package com.ifeanyi.cinema_house.movie.service;

import com.ifeanyi.cinema_house.exception.ForbiddenExceptionHandler;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.movie.entity.Movie;
import com.ifeanyi.cinema_house.movie.model.MovieModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {

    Movie create(MovieModel movieModel) throws NotFoundExceptionHandler, ForbiddenExceptionHandler;
    Movie get(String id) throws NotFoundExceptionHandler;
    List<Movie> getByTitle(String title, Pageable pageable);
    List<Movie> getByGenre(String genres,Pageable pageable);
    Movie update(String id,MovieModel movieModel) throws NotFoundExceptionHandler, ForbiddenExceptionHandler;
    void delete(String admin, String id) throws NotFoundExceptionHandler, ForbiddenExceptionHandler;
}
