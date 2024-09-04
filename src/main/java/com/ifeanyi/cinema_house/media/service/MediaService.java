package com.ifeanyi.cinema_house.media.service;

import com.ifeanyi.cinema_house.exception.ForbiddenExceptionHandler;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.media.model.Upload;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MediaService {

    String uploadHoriMovie(MultipartFile multipartFile, String id, String admin) throws IOException, NotFoundExceptionHandler, ForbiddenExceptionHandler;
    String uploadVertMovie(MultipartFile multipartFile, String id, String admin) throws IOException, NotFoundExceptionHandler, ForbiddenExceptionHandler;
    String uploadCast(MultipartFile multipartFile, String id, String admin) throws IOException, NotFoundExceptionHandler, ForbiddenExceptionHandler;
    byte[] download(String filename);
}
