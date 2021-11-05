package org.example.filters;

import org.example.queries.results.Results;

import java.util.stream.Collectors;

public record IncomeFilter(double from, double to) implements FiltrationCriteria{

    @Override
    public void Filtration(Results results) {
        if (from > 0) {
            results.setItems(results.getItems().stream()
                    .filter(p -> ((p.getIncome() >= from) && (p.getIncome() <= to)))
                    .collect(Collectors.toList()));
        }
    }
}