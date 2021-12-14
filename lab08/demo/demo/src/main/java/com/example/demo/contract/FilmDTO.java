package com.example.demo.contract;

import java.util.List;

public class FilmDTO {
    private String title;
    private String description;
    private int length;
    private int releaseYear;
    private String rating;
    private List<String> language;
    private List<String> filmActors;
    private List<String> filmCategories;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public List<String> getFilmActors() {
        return filmActors;
    }

    public void setFilmActors(List<String> filmActors) {
        this.filmActors = filmActors;
    }

    public List<String> getFilmCategories() {
        return filmCategories;
    }

    public void setFilmCategories(List<String> filmCategories) {
        this.filmCategories = filmCategories;
    }
}
