package com.example.demo.repositories.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(FilmNotFoundException.class)
    public ResponseEntity<HttpStatus> handleFilmNotFound() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(NoSuchPageException.class)
    public ResponseEntity<HttpStatus> handleNoSuchPage() {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
