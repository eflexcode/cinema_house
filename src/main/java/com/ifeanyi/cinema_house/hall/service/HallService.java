package com.ifeanyi.cinema_house.hall.service;

import com.ifeanyi.cinema_house.exception.ForbiddenExceptionHandler;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.hall.entity.Hall;
import com.ifeanyi.cinema_house.hall.model.HallModel;
import com.ifeanyi.cinema_house.movie.entity.Movie;
import com.ifeanyi.cinema_house.movie.model.MovieModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface HallService {

    Hall create(HallModel hallModel) throws NotFoundExceptionHandler, ForbiddenExceptionHandler;
    Hall get(String id) throws NotFoundExceptionHandler;
    List<Hall> findByShowingId(String showingId, Pageable pageable);
    Hall findByHallNumber(Integer hallNumber) throws NotFoundExceptionHandler;
    Hall update(String id,HallModel hallModel) throws NotFoundExceptionHandler, ForbiddenExceptionHandler;
    void delete(String admin, String id) throws NotFoundExceptionHandler, ForbiddenExceptionHandler;

}
