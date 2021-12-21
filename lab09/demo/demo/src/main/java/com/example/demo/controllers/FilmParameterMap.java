package com.example.demo.controllers;

import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilmParameterMap<TValue> extends HashMap<String, TValue> {
    private static final int defaultPageSize = 100;
    private static final int defaultPage = 1;
    private static final List<String> possibleParameters = List.of("id", "title", "language", "release_year", "rental_duration", "rental_rate", "replacement_cost");
    @Getter
    private final int page;
    @Getter
    private final int pageSize;

    public FilmParameterMap(Map<String, ? extends TValue> source) {
        super(source
                .entrySet()
                .stream()
                .filter(e -> possibleParameters.contains(e.getKey()))
                .filter(e -> !e.getValue().toString().trim().isEmpty())
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue)));

        this.page = source.containsKey("page") ? Integer.parseInt((String) source.get("page")) : defaultPage;
        this.pageSize = source.containsKey("page_size") ? Integer.parseInt((String) source.get("page_size")) : defaultPageSize;
    }
}
