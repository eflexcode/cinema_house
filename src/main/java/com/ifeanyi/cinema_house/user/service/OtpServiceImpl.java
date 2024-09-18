package com.ifeanyi.cinema_house.user.service;

import com.ifeanyi.cinema_house.exception.GoneException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import com.ifeanyi.cinema_house.user.entity.Otp;
import com.ifeanyi.cinema_house.user.entity.User;
import com.ifeanyi.cinema_house.user.model.UserModel;
import com.ifeanyi.cinema_house.user.repository.OtpRepository;
import com.ifeanyi.cinema_house.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;

@Service
@AllArgsConstructor
public class OtpServiceImpl implements OtpService {

    private final OtpRepository otpRepository;
    private final UserService userService;

    @Override
    public String generateOtp(String userId) {

        SecureRandom secureRandom = new SecureRandom();
        int randomNumber = secureRandom.nextInt(100000);
        String formattedRandomNumber = String.format("%05d", randomNumber);

        Otp otp = new Otp();
        otp.setId(userId);
        otp.setExpireTime(new Date(System.currentTimeMillis() + 5 * 60000));
        otp.setOtp(Integer.valueOf(formattedRandomNumber));

        otpRepository.save(otp);
        //TODO send user an email with a third party api

        return "Otp sent to your email";
    }

    @Override
    public Otp getByOtp(Integer otp) {
        return null;
    }

    @Override
    public String verifyOtp(Integer otpCode) throws NotFoundException, GoneException {

        Otp otp = otpRepository.findByOtp(otpCode).orElseThrow(() -> new GoneException("Otp error"));

        if (new Date().after(otp.getExpireTime())) {
            delete(otp.getId());
            throw new GoneException("Otp Expired");
        }

        UserModel userModel = new UserModel();
        userModel.setActivated(true);

        userService.update(otp.getId(),userModel);
        delete(otp.getId());

        return "Email verification successful";
    }

    @Override
    public void delete(String id) {
        otpRepository.deleteById(id);
    }

}
