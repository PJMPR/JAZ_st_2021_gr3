package com.example.demo.controllers;

import com.example.demo.BuilderPatternDemo.HashMapParamsFilms;
import com.example.demo.contracts.FilmDto;
import com.example.demo.model.Language;
import com.example.demo.services.FilmService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@Controller
@RequiredArgsConstructor
@RequestMapping("api/films")
public class FilmsController {

    private final FilmService filmService;


    @GetMapping()
    public ResponseEntity getFilmspage(@RequestParam(required = false) Integer id,@RequestParam(required = false) Integer page, @RequestParam(required = false) Language language,
                                       @RequestParam(required = false) String title, @RequestParam(required = false) Integer release_year,
                                       @RequestParam(required = false) Integer rental_duration,
                                       @RequestParam(required = false) BigDecimal rental_rate,
                                       @RequestParam(required = false) BigDecimal replacement_costs) {

        HashMapParamsFilms paramsMap = new HashMapParamsFilms(id,page,language,title,release_year,
                                                              rental_duration,rental_rate,replacement_costs);





        return ResponseEntity.ok(filmService.prepareFilms(paramsMap));


        // new object( ) <- z parametrami
        // uzupelniamy tym co dostalismy
        // pozniej sprawdzic co nie jest nullem
        // mapa obiektow <page, int> i tak dalej
        // <title, spiderman
    }

//    @GetMapping()
//    public ResponseEntity getFilmspage(@RequestParam Integer page) {
//        return ResponseEntity.ok(filmService.getFilmsPagepage(page));
//
//
//    }




    @PostMapping
    public ResponseEntity saveFilm(@RequestBody FilmDto film){
        //films.add(film);
        return ResponseEntity
                .noContent()
                .header("test", "test")
                .build();
    }

}
