package com.ifeanyi.cinema_house.movie.repository;

import com.ifeanyi.cinema_house.movie.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends MongoRepository<Movie,String> {

    Page<Movie> findByTitle(String title,Pageable pageable);
}
