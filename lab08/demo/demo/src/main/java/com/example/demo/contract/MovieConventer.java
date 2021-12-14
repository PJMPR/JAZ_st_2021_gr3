package com.example.demo.contract;

import com.example.demo.contract.LanguageDTO;
import com.example.demo.contract.MovieDto;
import com.example.demo.model.Film;
import com.example.demo.model.Language;
import com.example.demo.serviceAndRepo.Repositories.LanguageRepository;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieConventer {
    private final LanguageRepository languageRepository;

    public MovieConventer(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;

    }

    public Film dtoToEntity(MovieDto movieDto){
        Film film = new Film();
        film.setTitle(movieDto.getTitle());
        film.setDescription(movieDto.getDescription());
        film.setReleaseYear(castToYear(movieDto.getReleaseYear()));
        film.setLength(movieDto.getLength());
        film.setRating("G");                // do not know how to evaluate which rating should be
        film.setLastUpdate(actuallTime());
        film.setLanguage(getLanguageFromRepo(movieDto.getLanguage()));
        film.setFilmActors(new ArrayList<>());      // it is relation between two tables sooo...
        film.setFilmCategories(new ArrayList<>());    // it is relation between two tables sooo...
        return film;
    }


    private Language getLanguageFromRepo(List<LanguageDTO> languages) {
        String nameofLanguage = languages.get(0).getName();
        Language languageFromRepo = languageRepository.findByName(nameofLanguage);

        System.out.println(languageFromRepo.getName());

        if(languageFromRepo == null || languageFromRepo.equals(null)){
            languageFromRepo.setName(nameofLanguage);
            languageFromRepo.setLastUpdate(actuallTime());
            languageRepository.save(languageFromRepo);
        }
        return languageFromRepo;
    }



    private Timestamp actuallTime() {
        return new Timestamp(System.currentTimeMillis());
    }

    private int castToYear(String releaseYear) {
        String onlyDate = releaseYear.substring(0,4);
        return Integer.parseInt(onlyDate);
    }


}
