package org.example.filters;

import org.example.queries.results.Results;

import java.util.stream.Collectors;

public record AgeFilter(int from, int to) implements FiltrationCriteria{

    @Override
    public void Filtration(Results results) {
        if (from > 0) {
            results.setItems(results.getItems().stream()
                    .filter(p -> ((p.getAge() >= from) && (p.getAge() <= to)))
                    .collect(Collectors.toList()));
        }
    }
}