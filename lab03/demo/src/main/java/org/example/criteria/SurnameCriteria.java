package org.example.criteria;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.Locale;
import java.util.stream.Collectors;

public class SurnameCriteria implements Criteria{
    @Override
    public void criteriaUser(Results results, SearchParameters searchParameters) {
        if(searchParameters.getSurname() != null) {
            results.setItems(results
                    .getItems()
                    .stream()
                    .filter(person -> person.getSurname().equalsIgnoreCase(searchParameters.getSurname()))
                    .toList()
            );
        }
    }
}
