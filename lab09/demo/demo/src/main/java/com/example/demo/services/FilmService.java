package com.example.demo.services;

import com.example.demo.BuilderPatternDemo.HashMapParamsFilms;
import com.example.demo.BuilderPatternDemo.QueryBuilder;
import com.example.demo.contracts.FilmDto;
import com.example.demo.contracts.LanguageDto;
import com.example.demo.model.Film;
import com.example.demo.repositories.FilmsRepository;
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
    private int amountOfParamsInQuery = 0;


    public List<FilmDto> prepareFilms(HashMapParamsFilms paramsMap) {
        paramsMap.showAll();

        if(paramsMap.getIntegersValues().get("id") != null){
            prepareQuery("id",paramsMap);
        }
        if(paramsMap.getIntegersValues().get("releaseYear") != null){
            prepareQuery("releaseYear",paramsMap);
        }
        if(paramsMap.getIntegersValues().get("rentalDuration") != null){
            prepareQuery("rentalDuration",paramsMap);
        }
        if(paramsMap.getBigDecimalValues().get("rentalRate") != null){
            prepareQuery("rentalRate",paramsMap);
        }
        if(paramsMap.getBigDecimalValues().get("replacementCost") != null){
            prepareQuery("replacementCost",paramsMap);
        }
        if(paramsMap.getStringValue() != null){
            if(!paramsMap.getStringValue().equals("")){
                prepareTitleQuery(paramsMap.getStringValue());
            }
        }
        if(paramsMap.getLanguageValue() != null){
            System.out.println("TO language " + paramsMap.getLanguageValue().getName());

//            amountOfParamsInQuery++;
//            prepareQuery("language",paramsMap);
            // zapytanie do repo Language
        }

        List<Film> films = filmsRepository.executeQuery(queryBuilder.getQuery(),recordsToSkip(paramsMap));
        clearQuery();


        return films.stream().map(film -> new FilmDto(film.getFilmId(),
                            film.getTitle(),
                            film.getReleaseYear(),
                            new LanguageDto(film.getLanguage().getLanguageId(), film.getTitle()),
                            film.getRentalDuration(),
                            film.getRentalRate(),
                            film.getReplacementCost()))
                    .collect(Collectors.toList());

    }

    private void prepareTitleQuery( String title) {
        amountOfParamsInQuery++;

        if(amountOfParamsInQuery > 1){
            queryBuilder.addAND();
        }else {
            queryBuilder.addWhere();
        }

        queryBuilder.addToQuery("film.title LIKE '" +title +"%'");

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

    private void prepareQuery(String key, HashMapParamsFilms paramsMap) {
        System.out.println();
        System.out.println("AMOUNT OF PARAMS IN QUERY IS " + amountOfParamsInQuery);
        System.out.println("INFO INFO INFO ");
        System.out.println();

        amountOfParamsInQuery++;
        if(amountOfParamsInQuery > 1){
            queryBuilder.addAND();
        }else {
            queryBuilder.addWhere();
        }

        queryBuilder.addToQuery("film." + key + " = " + paramsMap.findValue(key));

    }


    private void clearQuery() {
        System.out.println("QUERY = " +queryBuilder.getQuery());
        queryBuilder.clear();
        amountOfParamsInQuery = 0;
    }
}