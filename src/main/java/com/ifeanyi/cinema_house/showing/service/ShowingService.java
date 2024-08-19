package com.ifeanyi.cinema_house.showing.service;

import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.hall.entity.Hall;
import com.ifeanyi.cinema_house.hall.model.HallModel;
import com.ifeanyi.cinema_house.showing.entity.Showing;
import com.ifeanyi.cinema_house.showing.model.ShowingModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShowingService {
    Showing create(ShowingModel showingModel) throws NotFoundExceptionHandler;
    Showing get(String id) throws NotFoundExceptionHandler;
    List<Showing> findAll(Pageable pageable);
    Showing update(String id,ShowingModel showingModel) throws NotFoundExceptionHandler;
    void delete(String admin, String id) throws NotFoundExceptionHandler;
}
