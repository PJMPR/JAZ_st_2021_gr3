package com.example.demo.contract;

import com.example.demo.model.Actor;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MovieDto {

    @JsonProperty("original_title")
    String title;
    String overview;
    int id;
    @JsonProperty("imdb_id")
    String imdbId;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
}
