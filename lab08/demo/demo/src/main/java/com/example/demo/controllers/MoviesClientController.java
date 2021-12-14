package com.example.demo.controllers;

import com.example.demo.contract.MovieDto;
import com.example.demo.serviceAndRepo.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("movies-client")
public class MoviesClientController {
   private Service service;

    public MoviesClientController(Service service) {
        this.service = service;
    }

    @GetMapping("{id}")
    public ResponseEntity GetMovie(@PathVariable int id){

        MovieDto movie = service.getMovie(id);
        service.moviedtoTOFilmAndSave(movie);

        return new ResponseEntity(movie,HttpStatus.OK);

    }
    @GetMapping("updater/reload")
    public void reload(){
    }

    @GetMapping("updater/reload?year={year}")
    public void reloadSpecyficYear(@PathVariable int year){

    }

    @GetMapping("updater/status")
    public void returnStatus(){

    }

    }
