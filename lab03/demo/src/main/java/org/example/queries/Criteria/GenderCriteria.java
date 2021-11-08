package org.example.queries.Criteria;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.stream.Collectors;

public class GenderCriteria implements Criteria{
    @Override
    public void meetCriteria(Results results, SearchParameters searchParameters) {
        results.setItems(results.getItems().stream()
                .filter(person -> searchParameters.getSelectedGenders().isEmpty() ||
                        searchParameters.getSelectedGenders().contains(person.getGender()))
                .collect(Collectors.toList()));
    }
}