package com.ifeanyi.cinema_house.movie.service;

import com.ifeanyi.cinema_house.admin.entity.Admin;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.movie.entity.Movie;
import com.ifeanyi.cinema_house.movie.model.MovieModel;
import com.ifeanyi.cinema_house.movie.repository.MovieRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService{

    private final MovieRepo movieRepo;

    @Override
    public Movie create(MovieModel movieModel) {

        Movie movie = new Movie();
        BeanUtils.copyProperties(movieModel,movie);

        Date date = new Date();
        movie.setCreatedAt(date);
        movie.setUpdatedAt(date);

        return movieRepo.save(movie);
    }

    @Override
    public Movie get(String id) throws NotFoundExceptionHandler {
        return movieRepo.findById(id).orElseThrow(()-> new NotFoundExceptionHandler("No movie found with id: "+id));
    }

    @Override
    public List<Movie> getByTitle(String title, Pageable pageable) {
        return movieRepo.findByTitle(title, pageable).toList();
    }

    @Override
    public Movie update(String id, MovieModel movieModel) throws NotFoundExceptionHandler {
        return null;
    }

    @Override
    public void delete(String id) throws NotFoundExceptionHandler {
        movieRepo.delete(get(id));
    }

}
