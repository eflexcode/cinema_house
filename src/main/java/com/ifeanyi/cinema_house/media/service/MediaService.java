package com.ifeanyi.cinema_house.media.service;

import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface MediaService {

    String uploadHoriMovie(MultipartFile multipartFile, String id, String admin) throws IOException, NotFoundException, ForbiddenException;
    String uploadVertMovie(MultipartFile multipartFile, String id, String admin) throws IOException, NotFoundException, ForbiddenException;
    String uploadCast(MultipartFile multipartFile, String id, String admin) throws IOException, NotFoundException, ForbiddenException;
    byte[] download(String filename);
}
