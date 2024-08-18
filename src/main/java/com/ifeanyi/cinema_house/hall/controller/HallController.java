package com.ifeanyi.cinema_house.hall.controller;

import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.hall.entity.Hall;
import com.ifeanyi.cinema_house.hall.model.HallModel;
import com.ifeanyi.cinema_house.hall.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HallController {

    private final HallService hallService;

    @PostMapping("/api/admin/hall")
    public Hall create(HallModel hallModel) throws NotFoundExceptionHandler {
        return hallService.create(hallModel);
    }

    @GetMapping("/api/hall/{id}")
    public Hall get(@PathVariable String id) throws NotFoundExceptionHandler {
        return hallService.get(id);
    }

    @GetMapping("/api/hall/{showingId}")
    public List<Hall> findByShowingId(@PathVariable String showingId, Pageable pageable) {
        return hallService.findByShowingId(showingId, pageable);
    }

    @GetMapping("/api/hall/{hallNumber}")
    public Hall findByHallNumber(@PathVariable Integer hallNumber) throws NotFoundExceptionHandler {
        return hallService.findByHallNumber(hallNumber);
    }

    @PutMapping("/api/admin/hall/{id}")
    public Hall update(@PathVariable String id,@RequestBody HallModel hallModel) throws NotFoundExceptionHandler {
        return hallService.update(id,hallModel);
    }

    @DeleteMapping("/api/admin/hall/{admin}/{id}")
    public void delete(@PathVariable String admin,@PathVariable String id) throws NotFoundExceptionHandler {
       hallService.delete(admin, id);
    }

}
