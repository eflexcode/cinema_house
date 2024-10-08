package com.ifeanyi.cinema_house.hall.controller;

import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.hall.entity.Hall;
import com.ifeanyi.cinema_house.hall.model.HallModel;
import com.ifeanyi.cinema_house.hall.service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HallController {

    private final HallService hallService;

    @PostMapping("/api/admin/hall")
    public Hall create(@RequestBody HallModel hallModel) throws NotFoundException, ForbiddenException {
        return hallService.create(hallModel);
    }

    @GetMapping("/api/hall/{id}")
    public Hall get(@PathVariable String id) throws NotFoundException {
        return hallService.get(id);
    }

    @GetMapping("/api/hall/showing/{showingId}")
    public List<Hall> findByShowingId(@PathVariable String showingId, Pageable pageable) {
        return hallService.findByShowingId(showingId, pageable);
    }

    @GetMapping("/api/hall/number/{hallNumber}")
    public Hall findByHallNumber(@PathVariable Integer hallNumber) throws NotFoundException {
        return hallService.findByHallNumber(hallNumber);
    }

    @PutMapping("/api/admin/hall/{id}")
    public Hall update(@PathVariable String id,@RequestBody HallModel hallModel) throws NotFoundException, ForbiddenException {
        return hallService.update(id,hallModel);
    }

    @DeleteMapping("/api/admin/hall/{admin}/{id}")
    public void delete(@PathVariable String admin,@PathVariable String id) throws NotFoundException, ForbiddenException {
       hallService.delete(admin, id);
    }

}
