package com.example.demo.services;

import com.example.demo.contracts.FilmDto;
import com.example.demo.contracts.LanguageDto;
import com.example.demo.controllers.FilmParameterMap;
import com.example.demo.model.Film;
import com.example.demo.repositories.FilmsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmsRepository filmsRepository;

    public List<FilmDto> getFilms(FilmParameterMap<String> parameters) {
        return filmsRepository.getFilms(parameters).stream().map(Film::to).toList();
    }

    public void saveFilm(FilmDto film) {
        filmsRepository.saveFilm(Film.from(film));
    }

    public void updateFilm(int id, FilmDto film) {
        film.setId(id);
        filmsRepository.updateFilm(Film.from(film));
    }

    public void deleteFilm(int id) {
        filmsRepository.deleteFilm(Film.from(new FilmDto(id, null, null, null, null, null, null)));
    }
}
