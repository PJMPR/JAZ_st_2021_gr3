package com.example.demo.services;

import com.example.demo.contracts.FilmDto;
import com.example.demo.contracts.LanguageDto;
import com.example.demo.repositories.FilmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmsRepository filmsRepository;

    public List<FilmDto> getFilms(){
        return filmsRepository.getFilms().stream().map(film->new FilmDto(film.getFilmId(),
                film.getTitle(),
                film.getReleaseYear(),
                new LanguageDto(film.getLanguage().getLanguageId(), film.getTitle()),
                film.getRentalDuration(),
                film.getRentalRate(),
                film.getReplacementCost()))
                .collect(Collectors.toList());

    }
}
