package com.ifeanyi.cinema_house.user.repository;

import com.ifeanyi.cinema_house.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
}
