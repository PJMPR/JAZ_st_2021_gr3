package com.example.demo.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class IMDBMovieDto {
    @JsonProperty("imdbID")
    String imdbId;
    @JsonProperty("Rated")
    String rating;
    @JsonProperty("Year")
    int year;
    @JsonProperty("Language")
    List<String> language;
    @JsonProperty("Genre")
    List<String> genre;
    @JsonProperty("Actors")
    List<String> actors;
    @JsonProperty("Runtime")
    String runtime;

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getActors() {
        return actors;
    }

    public void setActors(List<String> actors) {
        this.actors = actors;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public void setLanguage(String language) {
        this.language = List.of(language.split(", "));
    }
    public void setActors(String actors) {
        this.actors = List.of(actors.toUpperCase().split(", "));
    }

    public void setGenre(String genre) {this.genre = List.of(genre.split(", "));
    }
}
