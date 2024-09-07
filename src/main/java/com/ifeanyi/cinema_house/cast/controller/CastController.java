package com.ifeanyi.cinema_house.cast.controller;

import com.ifeanyi.cinema_house.cast.entity.Cast;
import com.ifeanyi.cinema_house.cast.model.CastModel;
import com.ifeanyi.cinema_house.cast.service.CastService;
import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CastController {

    private final CastService castService;

    @PostMapping("/api/admin/cast")
    public Cast create(@RequestBody CastModel castModel) throws NotFoundException, ForbiddenException {
        return castService.create(castModel);
    }
    @GetMapping("/api/cast/{id}")
    public Cast get(@PathVariable String id) throws NotFoundException {
        return castService.get(id);
    }
    @GetMapping("/api/cast")
    public List<Cast> getByName(@RequestParam String name, Pageable pageable) {
        return castService.getByName(name, pageable);
    }
    @PutMapping("/api/admin/cast/{id}")
    public Cast update(@PathVariable String id,@RequestBody CastModel castModel) throws NotFoundException, ForbiddenException {
        return castService.update(id, castModel);
    }
    @DeleteMapping("/api/admin/cast/{admin}/{id}")
    public void delete(@PathVariable String admin, @PathVariable String id) throws NotFoundException, ForbiddenException {
        castService.delete(admin, id);
    }

}
