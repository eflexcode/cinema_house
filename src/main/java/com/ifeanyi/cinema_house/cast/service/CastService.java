package com.ifeanyi.cinema_house.cast.service;

import com.ifeanyi.cinema_house.cast.entity.Cast;
import com.ifeanyi.cinema_house.cast.model.CastModel;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.movie.entity.Movie;
import com.ifeanyi.cinema_house.movie.model.MovieModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CastService {

    Cast create(CastModel castModel) throws NotFoundExceptionHandler;
    Cast get(String id) throws NotFoundExceptionHandler;
    List<Cast> getByName(String name, Pageable pageable);
    Cast update(String id,CastModel castModel) throws NotFoundExceptionHandler;
    void delete(String admin, String id) throws NotFoundExceptionHandler;

}
