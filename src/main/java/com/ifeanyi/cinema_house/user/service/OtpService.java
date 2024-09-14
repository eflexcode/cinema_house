package com.ifeanyi.cinema_house.user.service;

import com.ifeanyi.cinema_house.exception.GoneException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.user.entity.Otp;

public interface OtpService {

    String generateOtp(String userId);

    Otp getByOtp(Integer otp);

    String verifyOtp(Integer otp) throws NotFoundException, GoneException;

    void delete(String id);

}
