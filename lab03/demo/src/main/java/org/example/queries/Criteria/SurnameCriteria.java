package org.example.queries.Criteria;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class SurnameCriteria implements Criteria{
    @Override
    public void meetCriteria(Results results, SearchParameters searchParameters) {
        results.setItems(results.getItems().stream()
                .filter(person -> searchParameters.getSurname() == null ||
                        person.getSurname().equalsIgnoreCase(searchParameters.getSurname()))
                .toList());
    }
}
