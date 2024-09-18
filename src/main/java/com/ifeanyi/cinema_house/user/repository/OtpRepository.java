package com.ifeanyi.cinema_house.user.repository;

import com.ifeanyi.cinema_house.user.entity.Otp;
import com.ifeanyi.cinema_house.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRepository extends MongoRepository<Otp, String> {

    Optional<Otp> findByOtp(Integer otp);

}
