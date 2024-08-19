package com.ifeanyi.cinema_house.showing.repository;

import com.ifeanyi.cinema_house.showing.entity.Showing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowingRepository extends MongoRepository<Showing,String> {
}
