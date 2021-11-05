package org.example.queries.Criteria;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class NameCriteria implements Criteria{
    @Override
    public void meetCriteria(Results results, SearchParameters searchParameters) {
        results.setItems(results.getItems().stream()
                .filter(person -> searchParameters.getName() == null ||
                        person.getName().equalsIgnoreCase(searchParameters.getName()))
                .toList());
    }
}
