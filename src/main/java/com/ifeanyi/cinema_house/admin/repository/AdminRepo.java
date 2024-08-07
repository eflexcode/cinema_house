package com.ifeanyi.cinema_house.admin.repository;

import com.ifeanyi.cinema_house.admin.entity.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo extends MongoRepository<Admin,String> {
}
