package com.example.demo.services;

import com.example.demo.controllers.DTO.FilmDTO;
import com.example.demo.model.Film;
import com.example.demo.model.repos.FilmRepo;
import com.example.demo.services.handlers.ActorsHandler;
import com.example.demo.services.handlers.CategoryHandler;
import com.example.demo.services.handlers.Handler;
import com.example.demo.services.handlers.LanguageHandler;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
@AllArgsConstructor
public class FilmService {
    CategoryService categoryService;
    LanguageService languageService;
    ActorService actorService;
    FilmRepo filmRepo;
    @Autowired
    private ModelMapper modelMapper;

    public void updateFilm(FilmDTO filmDTO) {
        Handler handler = new LanguageHandler(languageService);
        handler.linkWith(new CategoryHandler(categoryService))
                .linkWith(new ActorsHandler(actorService));
        handler.check(filmDTO);

        Film film = modelMapper.map(filmDTO, Film.class);
        film.setLanguage(languageService.getLanguage(filmDTO.getLanguage().get(0)));
        film.setLastUpdate(new Timestamp(new Date().getTime()));
        filmRepo.save(film);

        Status status = Status.getInstance();
        status.setProgress(status.getProgress() + 1);
    }
}