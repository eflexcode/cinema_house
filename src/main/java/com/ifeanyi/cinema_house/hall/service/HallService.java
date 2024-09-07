package com.ifeanyi.cinema_house.hall.service;

import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.hall.entity.Hall;
import com.ifeanyi.cinema_house.hall.model.HallModel;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface HallService {

    Hall create(HallModel hallModel) throws NotFoundException, ForbiddenException;
    Hall get(String id) throws NotFoundException;
    List<Hall> findByShowingId(String showingId, Pageable pageable);
    Hall findByHallNumber(Integer hallNumber) throws NotFoundException;
    Hall update(String id,HallModel hallModel) throws NotFoundException, ForbiddenException;
    void delete(String admin, String id) throws NotFoundException, ForbiddenException;

}
