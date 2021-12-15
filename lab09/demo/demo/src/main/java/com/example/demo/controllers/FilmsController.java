package com.example.demo.controllers;

import com.example.demo.contracts.FilmDto;
import com.example.demo.contracts.LanguageDto;
import com.example.demo.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("api/films")
public class FilmsController {

    private final FilmService filmService;
    private static final List<FilmDto> films= List.of(
            new FilmDto(1, "nowy tytul", 2, new LanguageDto(1,"polish"),3, new BigDecimal(2.99), new BigDecimal(30.11)),
            new FilmDto(2, "nowy tytul", 2, new LanguageDto(1,"polish"),3, new BigDecimal(2.99), new BigDecimal(30.11)),
            new FilmDto(3, "nowy tytul", 2, new LanguageDto(1,"polish"),3, new BigDecimal(2.99), new BigDecimal(30.11)),
            new FilmDto(4, "nowy tytul", 2, new LanguageDto(1,"polish"),3, new BigDecimal(2.99), new BigDecimal(30.11)),
            new FilmDto(5, "nowy tytul", 2, new LanguageDto(1,"polish"),3, new BigDecimal(2.99), new BigDecimal(30.11)),
            new FilmDto(6, "nowy tytul", 2, new LanguageDto(1,"polish"),3, new BigDecimal(2.99), new BigDecimal(30.11)),
            new FilmDto(7, "nowy tytul", 2, new LanguageDto(1,"polish"),3, new BigDecimal(2.99), new BigDecimal(30.11)),
            new FilmDto(8, "nowy tytul", 2, new LanguageDto(1,"polish"),3, new BigDecimal(2.99), new BigDecimal(30.11))
    ).stream().collect(Collectors.toList());

    @GetMapping
    public ResponseEntity getFilms(){
        return ResponseEntity.ok(filmService.getFilms());
    }

    @PostMapping
    public ResponseEntity saveFilm(@RequestBody FilmDto film){
        films.add(film);
        return ResponseEntity
                .noContent()
                .header("test", "test")
                .build();
    }

}
