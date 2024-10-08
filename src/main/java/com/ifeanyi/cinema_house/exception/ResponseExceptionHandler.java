package com.ifeanyi.cinema_house.exception;

import jakarta.servlet.ServletException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorModel> notFoundExceptionHandler(NotFoundException notFoundException) {
        return new ResponseEntity<>(new ErrorModel(notFoundException.getMessage(), new Date(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ForbiddenException.class)
    public ResponseEntity<ErrorModel> forbiddenExceptionHandler(ForbiddenException forbiddenException) {
        return new ResponseEntity<>(new ErrorModel(forbiddenException.getMessage(), new Date(), HttpStatus.FORBIDDEN.value()), HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorModel> unauthorizedExceptionHandler(UnauthorizedException unauthorizedException) {
        return new ResponseEntity<>(new ErrorModel(unauthorizedException.getMessage(), new Date(), HttpStatus.UNAUTHORIZED.value()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<ErrorModel> duplicateExceptionHandler(DuplicateException duplicateException) {
        return new ResponseEntity<>(new ErrorModel(duplicateException.getMessage(), new Date(), HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorModel> badRequestExceptionHandler(BadRequestException badRequestException) {
        return new ResponseEntity<>(new ErrorModel(badRequestException.getMessage(), new Date(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(GoneException.class)
    public ResponseEntity<ErrorModel> goneExceptionHandler(GoneException goneException) {
        return new ResponseEntity<>(new ErrorModel(goneException.getMessage(), new Date(), HttpStatus.GONE.value()), HttpStatus.GONE);
    }
}
