package com.example.demo.controllers.DTO;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class OMDbDTO {
    @JsonAlias({"imdbID"})
    private String imdbId;

    @JsonAlias({"Year"})
    private int releaseYear;

    @JsonAlias({"Rated"})
    private String rating;

    @JsonAlias({"Language"})
    private List<String> language;

    @JsonAlias({"Actors"})
    private List<String> filmActors;

    @JsonAlias({"Genre"})
    private List<String> filmCategories;

    public void setLanguage(String language) {
        this.language = List.of(language.split(", "));
    }

    public void setFilmActors(String filmActors) {
        this.filmActors = List.of(filmActors.toUpperCase().split(", "));
    }

    public void setFilmCategories(String filmCategories) {
        this.filmCategories = List.of(filmCategories.split(", "));
    }
}