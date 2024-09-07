package com.ifeanyi.cinema_house.media.controller;

import com.ifeanyi.cinema_house.exception.ForbiddenException;
import com.ifeanyi.cinema_house.exception.NotFoundException;
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

    @PostMapping("/api/media/hori/{id}/{admin}")
    public String uploadHorizontal(@RequestParam("file") MultipartFile multipartFile, @PathVariable String id,@PathVariable String admin) throws IOException, NotFoundException, ForbiddenException {
        return mediaService.uploadHoriMovie(multipartFile, id,admin);
    }
    @PostMapping("/api/media/vert/{id}/{admin}")
    public String uploadVertical(@RequestParam("file") MultipartFile multipartFile,@PathVariable String id,@PathVariable String admin) throws IOException, NotFoundException, ForbiddenException {
        return mediaService.uploadVertMovie(multipartFile, id,admin);
    }
    @PostMapping("/api/media/cast/{id}/{admin}")
    public String uploadCast(@RequestParam("file") MultipartFile multipartFile,@PathVariable String id,@PathVariable String admin) throws IOException, NotFoundException, ForbiddenException {
        return mediaService.uploadCast(multipartFile, id,admin);
    }
    @GetMapping("/api/media/{filename}")
    public ResponseEntity<?> download(@PathVariable String filename) throws IOException, NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf(MediaType.IMAGE_PNG_VALUE)).body(mediaService.download(filename));
    }
}
