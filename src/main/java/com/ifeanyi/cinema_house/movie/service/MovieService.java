package com.ifeanyi.cinema_house.movie.service;

import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.movie.entity.Movie;
import com.ifeanyi.cinema_house.movie.model.MovieModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovieService {

    Movie create(MovieModel movieModel) throws NotFoundException, ForbiddenException;
    Movie get(String id) throws NotFoundException;
    List<Movie> getByTitle(String title, Pageable pageable);
    List<Movie> getByGenre(String genres,Pageable pageable);
    Movie update(String id,MovieModel movieModel) throws NotFoundException, ForbiddenException;
    void delete(String admin, String id) throws NotFoundException, ForbiddenException;
}
