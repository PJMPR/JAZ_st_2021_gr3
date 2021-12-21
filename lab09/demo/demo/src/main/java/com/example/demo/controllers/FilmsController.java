package com.example.demo.controllers;

import com.example.demo.contracts.FilmDto;
import com.example.demo.contracts.LanguageDto;
import com.example.demo.model.Film;
import com.example.demo.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/films")
public class FilmsController {

    private final FilmService filmService;

    @GetMapping
    public ResponseEntity<List<FilmDto>> getFilms(@RequestParam Map<String, String> params) {
        return ResponseEntity.ok(filmService.getFilms(new FilmParameterMap<>(params)));
    }

    @PostMapping
    public ResponseEntity<Void> saveFilm(@RequestBody FilmDto film) {
        filmService.saveFilm(film);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateFilm(@PathVariable int id, @RequestBody FilmDto film) {
        filmService.updateFilm(id, film);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable int id) {
        filmService.deleteFilm(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
