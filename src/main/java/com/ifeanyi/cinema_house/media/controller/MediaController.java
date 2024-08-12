package com.ifeanyi.cinema_house.media.controller;

import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.media.model.Upload;
import com.ifeanyi.cinema_house.media.model.UploadDestination;
import com.ifeanyi.cinema_house.media.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping("/api/media/hori")
    public String uploadHorizontal(@RequestParam("file") MultipartFile multipartFile, @RequestBody Upload upload) throws IOException, NotFoundExceptionHandler {
        return mediaService.uploadHoriMovie(multipartFile, upload);
    }
    @PostMapping("/api/media/vert")
    public String uploadVertical(@RequestParam("file") MultipartFile multipartFile, @RequestBody Upload upload) throws IOException, NotFoundExceptionHandler {
        return mediaService.uploadVertMovie(multipartFile, upload);
    }
    @PostMapping("/api/media/cast")
    public String uploadCast(@RequestParam("file") MultipartFile multipartFile, @RequestBody Upload upload) throws IOException, NotFoundExceptionHandler {
        return mediaService.uploadCast(multipartFile, upload);
    }
    @GetMapping("/api/media/{filename}")
    public ResponseEntity<?> download(@PathVariable String filename) throws IOException, NotFoundExceptionHandler {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE)).body(mediaService.download(filename));
    }
}
