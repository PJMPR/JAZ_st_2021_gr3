package com.example.demo.controllers;

import com.example.demo.QueryBuilder;
import com.example.demo.contracts.FilmDto;
import com.example.demo.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/films")
public class FilmsController {

    private final FilmService filmService;

    @GetMapping
    public ResponseEntity<List<FilmDto>> getFilms(@RequestParam("page") final Optional<Integer> page,
                                               @RequestParam("id") final Optional<Integer> id,
                                               @RequestParam("title") final Optional<String> title,
                                               @RequestParam("language") final Optional<Integer> language,
                                               @RequestParam("release_year") final Optional<String> releaseYear,
                                               @RequestParam("rental_duration") final Optional<String> rentalDuration,
                                               @RequestParam("rental_rate") final Optional<String> rentalRate,
                                               @RequestParam("replacement_cost") final Optional<String> replacementCost){

        var query = QueryBuilder.buildQuery(id,title, language, releaseYear, rentalDuration, rentalRate, replacementCost);
        return ResponseEntity.ok(filmService.getFilms(page.orElse(1), query));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteFilm(@PathVariable Integer id){
        filmService.delete(id);//change in database on delete cascade i ll not write 20 lines of code
        return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateFilm(@PathVariable Integer id, @RequestBody FilmDto filmDto){
        filmService.updateFilm(id, filmDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PostMapping
    public ResponseEntity<?> saveFilm(@RequestBody FilmDto film){
        filmService.add(film.getId(), film);
        return ResponseEntity.ok().build();
    }

}
