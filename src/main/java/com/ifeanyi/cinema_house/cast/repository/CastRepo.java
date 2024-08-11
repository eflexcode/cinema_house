package com.ifeanyi.cinema_house.cast.repository;

import com.ifeanyi.cinema_house.cast.entity.Cast;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoAdminOperations;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastRepo extends MongoRepository<Cast,String> {

        Page<Cast> findByNameContainingIgnoreCase(String name,Pageable pageable);
}
