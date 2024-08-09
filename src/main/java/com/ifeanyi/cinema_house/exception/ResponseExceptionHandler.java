package com.ifeanyi.cinema_house.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundExceptionHandler.class)
    public ResponseEntity<ErrorModel>  notFoundExceptionHandler(NotFoundExceptionHandler notFoundExceptionHandler){
        return new ResponseEntity<>(new ErrorModel(notFoundExceptionHandler.getMessage(),new Date(),HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

}
