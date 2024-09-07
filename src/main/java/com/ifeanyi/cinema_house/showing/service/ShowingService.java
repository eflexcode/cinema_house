package com.ifeanyi.cinema_house.showing.service;

import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.showing.entity.Showing;
import com.ifeanyi.cinema_house.showing.model.ShowingModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShowingService {
    Showing create(ShowingModel showingModel) throws NotFoundException, ForbiddenException;
    Showing get(String id) throws NotFoundException;
    List<Showing> findAll(Pageable pageable);
    Showing update(String id,ShowingModel showingModel) throws NotFoundException, ForbiddenException;
    void delete(String admin, String id) throws NotFoundException, ForbiddenException;
}
