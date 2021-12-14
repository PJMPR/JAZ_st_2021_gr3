package com.example.demo.controllers;

import com.example.demo.service.FilmService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("updater")
public class UpdaterController {
    RestTemplate rest;
    FilmService filmService;

    public UpdaterController(RestTemplate rest, FilmService filmService) {
        this.rest = rest;
        this.filmService = filmService;
    }


    @GetMapping("reload")
    public ResponseEntity reloadData(@RequestParam(defaultValue = "1999") String year){
        return ResponseEntity.ok("ended");
    }
}
