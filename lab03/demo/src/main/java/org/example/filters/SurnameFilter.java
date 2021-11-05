package org.example.filters;

import org.example.queries.results.Results;

import java.util.stream.Collectors;

public record SurnameFilter(String surname) implements FiltrationCriteria{

    @Override
    public void Filtration(Results results) {
        if (surname != null) {
            results.setItems(results.getItems().stream()
                    .filter(p -> p.getSurname().equals(surname))
                    .collect(Collectors.toList()));
        }
    }
}