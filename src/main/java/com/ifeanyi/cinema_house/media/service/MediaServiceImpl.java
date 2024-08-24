package com.ifeanyi.cinema_house.media.service;

import com.ifeanyi.cinema_house.cast.model.CastModel;
import com.ifeanyi.cinema_house.cast.service.CastService;
import com.ifeanyi.cinema_house.exception.NotFoundExceptionHandler;
import com.ifeanyi.cinema_house.media.model.Upload;
import com.ifeanyi.cinema_house.movie.model.MovieModel;
import com.ifeanyi.cinema_house.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;

@Service
@RequiredArgsConstructor
public class MediaServiceImpl implements MediaService {

    private final String uploadPath = "C:/Users/E.F.Lhomes/Desktop/cinema_house/";
    public static final String downloadPath = "http://localhost:8080/api/media/";

    private final MovieService movieService;
    private final CastService castService;
    //TODO user media

    // this is the only way i could think of (:
    @Override
    public String uploadHoriMovie(MultipartFile multipartFile, String id, String admin) throws IOException, NotFoundExceptionHandler {
        int i = multipartFile.getOriginalFilename().lastIndexOf('.');
        String fileName = String.valueOf(System.currentTimeMillis())+multipartFile.getOriginalFilename().substring(i);

        File file = new File(uploadPath, fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();

        String downloadUrl = downloadPath + fileName;

        MovieModel movieModel = new MovieModel();
        movieModel.setHorizontalImageUrl(downloadUrl);
        movieModel.setUpdatedByAdmin(admin);
        movieService.update(id, movieModel);

        return "Image upload successfully";
    }

    @Override
    public String uploadVertMovie(MultipartFile multipartFile,String id, String admin) throws IOException, NotFoundExceptionHandler {
        String fileName = String.valueOf(System.currentTimeMillis());

        File file = new File(uploadPath, fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();

        String downloadUrl = downloadPath + fileName;

        MovieModel movieModel = new MovieModel();
        movieModel.setVerticalImageUrl(downloadUrl);
        movieModel.setUpdatedByAdmin(admin);
        movieService.update(id, movieModel);

        return "Image upload successfully";
    }

    @Override
    public String uploadCast(MultipartFile multipartFile, String id, String admin) throws IOException, NotFoundExceptionHandler {
        String fileName = String.valueOf(System.currentTimeMillis());

        File file = new File(uploadPath, fileName);
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();

        String downloadUrl = downloadPath + fileName;

        CastModel castModel = new CastModel();
        castModel.setImageUrl(downloadUrl);
        castModel.setUpdatedByAdmin(admin);
        castService.update(id,castModel);

        return "Image upload successfully";
    }

    @Override
    public byte[] download(String filename) {

        String filepath = uploadPath+filename;
        byte[] image;
        try {
            image = Files.readAllBytes(new File(filepath).toPath());
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return image;
    }

}
