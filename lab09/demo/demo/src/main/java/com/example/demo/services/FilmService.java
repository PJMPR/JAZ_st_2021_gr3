package com.example.demo.services;

import com.example.demo.contracts.FilmDto;
import com.example.demo.contracts.LanguageDto;
import com.example.demo.model.Film;
import com.example.demo.model.Language;
import com.example.demo.repositories.FilmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmsRepository filmsRepository;

    public List<FilmDto> getFilms(Integer page, String query) {
        return filmsRepository.getFilms(page,query).stream().map(film -> new FilmDto(film.getFilmId(), film.getTitle(), film.getReleaseYear(),
                new LanguageDto(film.getLanguage().getLanguageId(), film.getTitle()),
                film.getRentalDuration(), film.getRentalRate(), film.getReplacementCost())).collect(Collectors.toList());

    }

    public void updateFilm(Integer id, FilmDto filmDto) {
        filmsRepository.updateFilm(new Film(id, filmDto.getTitle(), filmDto.getReleaseYear(), filmDto.getRentalDuration(), filmDto.getRentalRate(),
                filmDto.getReplacementCosts(), Timestamp.from(Instant.now()),
                new Language(filmDto.getLanguage().getId(), filmDto.getLanguage().getName())));
    }

    public Film getFilm(Integer id) {
        return filmsRepository.getFilm(id);
    }


    public void delete(Integer id) {
        filmsRepository.delete(id);
    }

    public void add(Integer id, FilmDto filmDto) {
        filmsRepository.addFilm(new Film(id, filmDto.getTitle(), filmDto.getReleaseYear(), filmDto.getRentalDuration(),
                filmDto.getRentalRate(), filmDto.getReplacementCosts(), Timestamp.from(Instant.now()),
                new Language(filmDto.getLanguage().getId(), filmDto.getLanguage().getName())));
    }
}
