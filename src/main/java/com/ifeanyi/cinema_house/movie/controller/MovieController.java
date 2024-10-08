package com.ifeanyi.cinema_house.movie.controller;

import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.movie.entity.Movie;
import com.ifeanyi.cinema_house.movie.model.MovieModel;
import com.ifeanyi.cinema_house.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @PostMapping("/api/admin/movie")
    public Movie create(@RequestBody MovieModel movieModel) throws NotFoundException, ForbiddenException {
        return movieService.create(movieModel);
    }
    @GetMapping("/api/movie/{id}")
    public Movie get(@PathVariable String id) throws NotFoundException {
        return movieService.get(id);
    }
    @GetMapping("/api/movie/title")
    public List<Movie> getByTitle(@RequestParam String title, Pageable pageable) {
        return movieService.getByTitle(title, pageable);
    }
    @GetMapping("/api/movie/genres")
    public List<Movie> getByGenre(@RequestParam String genres, Pageable pageable) {
        return movieService.getByGenre(genres, pageable);
    }
    @PutMapping("/api/admin/movie/{id}")
    public Movie update(@PathVariable String id, MovieModel movieModel) throws NotFoundException, ForbiddenException {
        return movieService.update(id,movieModel);
    }
    @DeleteMapping ("/api/admin/movie/{admin}/{id}")
    public void delete(@PathVariable String admin,@PathVariable String id) throws NotFoundException, ForbiddenException {
        movieService.delete(admin, id);
    }

}
