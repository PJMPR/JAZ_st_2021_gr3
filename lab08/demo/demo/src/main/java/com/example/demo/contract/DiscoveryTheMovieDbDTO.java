package com.example.demo.contract;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DiscoveryTheMovieDbDTO {
    @JsonProperty("page")
    int page;
    @JsonProperty("results")
    List<MovieDto> results;
    @JsonProperty("total_pages")
    int total_pages;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public List<MovieDto> getResults() {
        return results;
    }

    public void setResults(List<MovieDto> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
