package com.ifeanyi.cinema_house.hall.repository;

import com.ifeanyi.cinema_house.hall.entity.Hall;
import com.ifeanyi.cinema_house.movie.entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HallRepo extends MongoRepository<Hall,String> {
    Page<Hall> findByShowingId(String showingId, Pageable pageable);
    Optional<Hall> findByHallNumber(Integer hallNumber);
}
