package com.ifeanyi.cinema_house.cast.service;

import com.ifeanyi.cinema_house.Util;
import com.ifeanyi.cinema_house.cast.entity.Cast;
import com.ifeanyi.cinema_house.cast.model.CastModel;
import com.ifeanyi.cinema_house.cast.repository.CastRepo;
import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CastServiceImpl implements CastService {

    private final UserService userService;
    private final CastRepo repo;

    @Override
    public Cast create(CastModel castModel) throws NotFoundException, ForbiddenException {

        Util.isUserAdmin(castModel.getCreatedByAdmin(),userService);

        Cast cast = new Cast();
        BeanUtils.copyProperties(castModel, cast);
        cast.setUpdatedByAdmin(castModel.getCreatedByAdmin());

        Date date = new Date();
        cast.setCreatedAt(date);
        cast.setUpdatedAt(date);

        return repo.save(cast);
    }

    @Override
    public Cast get(String id) throws NotFoundException {
        return repo.findById(id).orElseThrow(() -> new NotFoundException("No cast found with id: " + id));
    }

    @Override
    public List<Cast> getByName(String name, Pageable pageable) {
        return repo.findByNameContainingIgnoreCase(name, pageable).toList();
    }

    @Override
    public Cast update(String id, CastModel castModel) throws NotFoundException, ForbiddenException {
        Util.isUserAdmin(castModel.getCreatedByAdmin(),userService);

        Cast cast = get(id);
        cast.setName(castModel.getName() != null ? castModel.getName() : cast.getName());
        cast.setDescription(castModel.getDescription() != null ? castModel.getDescription() : cast.getDescription());
        cast.setImageUrl(castModel.getImageUrl() != null ? castModel.getImageUrl() : cast.getImageUrl());
        cast.setMovieIds(castModel.getMovieIds() != null ? castModel.getMovieIds() : cast.getMovieIds());

        return repo.save(cast);
    }

    @Override
    public void delete(String admin, String id) throws NotFoundException, ForbiddenException {
        Util.isUserAdmin(admin,userService);

        repo.delete(get(id));
    }
}
