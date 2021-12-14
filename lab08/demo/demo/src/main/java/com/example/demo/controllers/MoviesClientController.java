package com.example.demo.controllers;

import com.example.demo.contract.MovieDto;
import org.springframework.beans.factory.annotation.Value;
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

    public MoviesClientController(RestTemplate rest) {
        this.rest = rest;
    }

    @GetMapping("{id}")
    public ResponseEntity GetMovie(@PathVariable int id){

        var movie = rest.getForEntity("https://api.themoviedb.org/3/movie/" +
                id +
                "?api_key=aaa1e2f9cf290db26e0ebf0c7cddc455" , MovieDto.class).getBody();

        return ResponseEntity.ok(movie);

    }

}
