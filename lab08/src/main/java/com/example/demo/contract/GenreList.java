package com.example.demo.contract;

public class GenreList {
    private Genre[] genres;

    public GenreList(Genre[] genres) {
        this.genres = genres;
    }

    public GenreList() { }

    public Genre[] getGenres() {
        return genres;
    }

    public void setGenres(Genre[] genres) {
        this.genres = genres;
    }
}
