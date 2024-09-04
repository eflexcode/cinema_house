package com.ifeanyi.cinema_house.showing.controller;

import com.ifeanyi.cinema_house.exception.ForbiddenExceptionHandler;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.showing.entity.Showing;
import com.ifeanyi.cinema_house.showing.model.ShowingModel;
import com.ifeanyi.cinema_house.showing.service.ShowingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShowingController {

    private final ShowingService showingService;

    @PostMapping("/api/admin/showing")
    public Showing create(@RequestBody ShowingModel showingModel) throws NotFoundExceptionHandler, ForbiddenExceptionHandler {
        return showingService.create(showingModel);
    }
    @GetMapping("/api/showing/{id}")
    public Showing get(@PathVariable String id) throws NotFoundExceptionHandler {
        return showingService.get(id);
    }

    @GetMapping("/api/showing")
    public List<Showing> findAll(Pageable pageable) {
        return showingService.findAll(pageable);
    }

    @PutMapping("/api/admin/showing/{id}")
    public Showing update(@PathVariable String id, @RequestBody ShowingModel showingModel) throws NotFoundExceptionHandler, ForbiddenExceptionHandler {
        return showingService.update(id, showingModel);
    }

    @DeleteMapping("/api/admin/showing/{admin}/{id}")
    public void delete(@PathVariable String admin, @PathVariable String id) throws NotFoundExceptionHandler, ForbiddenExceptionHandler {
        showingService.delete(admin, id);
    }

}
