package com.example.demo.controllers;

import com.example.demo.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("movies-client")
public class MoviesClientController {

    RestTemplate rest;
    FilmService filmService;


    public MoviesClientController(RestTemplate rest, FilmService filmService) {
        this.rest = rest;
        this.filmService = filmService;
    }

    @GetMapping("{id}")
    public ResponseEntity GetMovie(@PathVariable int id){
        var movie = filmService.getMovieFromTheMovieDb(id);
        return ResponseEntity.ok(movie);

    }

    @GetMapping("/imdb/{id}")
    public ResponseEntity getDataIMDB(@PathVariable String id){
        var movie = filmService.getMovieFromIMDB(id);
        return ResponseEntity.ok(movie);
    }

}
