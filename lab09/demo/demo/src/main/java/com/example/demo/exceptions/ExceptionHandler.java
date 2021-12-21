package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(FilmNotFoundException.class)
    public ResponseEntity<HttpStatus> handleFilmNotFound(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchPageException.class)
    public ResponseEntity<HttpStatus> handleNoSuchPage(){
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
