package com.example.demo.services;

import com.example.demo.BuilderPatternDemo.HashMapParamsFilms;
import com.example.demo.BuilderPatternDemo.QueryBuilder;
import com.example.demo.contracts.FilmDto;
import com.example.demo.contracts.LanguageDto;
import com.example.demo.model.Film;
import com.example.demo.repositories.FilmsRepository;
import com.example.demo.repositories.LanguageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FilmService {
    private final FilmsRepository filmsRepository;
    private final QueryBuilder queryBuilder;
    private final int PAGE_CAPACITY = 30;


    public List<FilmDto> prepareFilms(HashMapParamsFilms paramsMap) {
        paramsMap.showAll();

        if(paramsMap.getIntegersValues().get("id") != null){
            queryBuilder.prepareQuery("id",paramsMap);
        }
        if(paramsMap.getIntegersValues().get("releaseYear") != null){
            queryBuilder.prepareQuery("releaseYear",paramsMap);
        }
        if(paramsMap.getIntegersValues().get("rentalDuration") != null){
            queryBuilder.prepareQuery("rentalDuration",paramsMap);
        }
        if(paramsMap.getBigDecimalValues().get("rentalRate") != null){
            queryBuilder.prepareQuery("rentalRate",paramsMap);
        }
        if(paramsMap.getBigDecimalValues().get("replacementCost") != null){
            queryBuilder.prepareQuery("replacementCost",paramsMap);
        }
        if(paramsMap.getStringValue() != null){
            if(!paramsMap.getStringValue().equals("")){
                queryBuilder.prepareTitleQuery(paramsMap.getStringValue());
            }
        }
        if(paramsMap.getLanguageValue() != null){
            queryBuilder.prepareLanguageQuery(paramsMap.getLanguageValue().getName());
        }

        List<Film> films = filmsRepository.executeQuery(queryBuilder.getQuery(),recordsToSkip(paramsMap));
        queryBuilder.clear();


        return films.stream().map(film -> new FilmDto(film.getFilmId(),
                            film.getTitle(),
                            film.getReleaseYear(),
                            new LanguageDto(film.getLanguage().getLanguageId(), film.getLanguage().getName()),
                            film.getRentalDuration(),
                            film.getRentalRate(),
                            film.getReplacementCost()))
                    .collect(Collectors.toList());

    }



    private int recordsToSkip(HashMapParamsFilms paramsMap) {
        int page;

        if(paramsMap.getIntegersValues().get("page")==null || paramsMap.getIntegersValues().get("page") < 1){
            page = 0;
        }else {
            page = paramsMap.getIntegersValues().get("page") - 1 ;
        }
        return PAGE_CAPACITY * page;
    }

    public void addFilmToDB(FilmDto filmdto) {
        Film film = filmdto.dtoTOEntity();
        filmsRepository.save(film);
    }
}