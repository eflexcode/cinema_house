package com.ifeanyi.cinema_house.user.repository;

import com.ifeanyi.cinema_house.user.entity.Otp;
import com.ifeanyi.cinema_house.user.entity.ResetPasswordToken;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResetPasswordRepository extends MongoRepository<ResetPasswordToken, String> {

    Optional<ResetPasswordToken> findByToken(String token);

    Optional<ResetPasswordToken> findByUserId(String userId);

}
