package com.ifeanyi.cinema_house.movie.repository;

import com.ifeanyi.cinema_house.movie.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends MongoRepository<Movie,String> {

    Page<Movie> findByTitleContainingIgnoreCase(String title,Pageable pageable);
    Page<Movie> findByGenresContainingIgnoreCase(String genres,Pageable pageable);
}
