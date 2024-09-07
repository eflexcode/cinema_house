package com.ifeanyi.cinema_house.cast.service;

import com.ifeanyi.cinema_house.cast.entity.Cast;
import com.ifeanyi.cinema_house.cast.model.CastModel;
import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CastService {

    Cast create(CastModel castModel) throws NotFoundException, ForbiddenException;
    Cast get(String id) throws NotFoundException;
    List<Cast> getByName(String name, Pageable pageable);
    Cast update(String id,CastModel castModel) throws NotFoundException, ForbiddenException;
    void delete(String admin, String id) throws NotFoundException, ForbiddenException;

}
