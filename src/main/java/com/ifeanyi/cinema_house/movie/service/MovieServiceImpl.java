package com.ifeanyi.cinema_house.movie.service;

import com.ifeanyi.cinema_house.Util;
import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.movie.entity.Movie;
import com.ifeanyi.cinema_house.movie.model.MovieModel;
import com.ifeanyi.cinema_house.movie.repository.MovieRepo;
import com.ifeanyi.cinema_house.user.service.UserService;
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
    private final UserService userService;

    @Override
    public Movie create(MovieModel movieModel) throws NotFoundException, ForbiddenException {
        Util.isUserAdmin(movieModel.getUpdatedByAdmin(), userService);

        Movie movie = new Movie();
        BeanUtils.copyProperties(movieModel,movie);

        Date date = new Date();
        movie.setCreatedAt(date);
        movie.setUpdatedAt(date);

        return movieRepo.save(movie);
    }

    @Override
    public Movie get(String id) throws NotFoundException {
        return movieRepo.findById(id).orElseThrow(()-> new NotFoundException("No movie found with id: "+id));
    }

    @Override
    public List<Movie> getByTitle(String title, Pageable pageable) {
        return movieRepo.findByTitleContainingIgnoreCase(title, pageable).toList();
    }

    @Override
    public List<Movie> getByGenre(String genres, Pageable pageable) {
        return movieRepo.findByGenresContainingIgnoreCase(genres, pageable).toList();
    }

    @Override
    public Movie update(String id, MovieModel movieModel) throws NotFoundException, ForbiddenException {

        Movie movie = get(id);
        movie.setTitle(movieModel.getTitle() != null ? movieModel.getTitle() : movie.getTitle());
        movie.setDescription(movieModel.getDescription() != null ? movieModel.getDescription() : movie.getDescription());
        movie.setShortDescription(movieModel.getShortDescription() != null ? movieModel.getShortDescription() : movie.getShortDescription());
        movie.setGenres(movieModel.getGenres() != null ? movieModel.getGenres() : movie.getGenres());
        movie.setReleaseDate(movieModel.getReleaseDate() != null ? movieModel.getReleaseDate() : movie.getReleaseDate());
        movie.setLikeCount(movieModel.getLikeCount() != null ? movieModel.getLikeCount() : movie.getLikeCount());
        movie.setDisLikeCount(movieModel.getDisLikeCount() != null ? movieModel.getDisLikeCount() : movie.getDisLikeCount());
        movie.setVerticalImageUrl(movieModel.getVerticalImageUrl() != null ? movieModel.getVerticalImageUrl() : movie.getVerticalImageUrl());
        movie.setHorizontalImageUrl(movieModel.getHorizontalImageUrl() != null ? movieModel.getHorizontalImageUrl() : movie.getHorizontalImageUrl());

        Util.isUserAdmin(movieModel.getUpdatedByAdmin(), userService);
        movie.setUpdatedByAdmin(movieModel.getUpdatedByAdmin() != null ? movieModel.getUpdatedByAdmin() : movie.getUpdatedByAdmin());

        if (movieModel.getCastIds() != null){
            movie.setCastIds(movieModel.getCastIds());
        }

        movie.setUpdatedAt(new Date());
        System.out.println("llllllllllllllllllllllllllllllllllllllllllllll");

        return movieRepo.save(movie);
    }

    @Override
    public void delete(String admin, String id) throws NotFoundException, ForbiddenException {
        Util.isUserAdmin(admin, userService);
        movieRepo.delete(get(id));
    }

}