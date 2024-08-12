package com.ifeanyi.cinema_house.media.service;

import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.media.model.Upload;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MediaService {

    String uploadHoriMovie(MultipartFile multipartFile, Upload upload) throws IOException, NotFoundExceptionHandler;
    String uploadVertMovie(MultipartFile multipartFile, Upload upload) throws IOException, NotFoundExceptionHandler;
    String uploadCast(MultipartFile multipartFile, Upload upload) throws IOException, NotFoundExceptionHandler;
    byte[] download(String filename);
}
