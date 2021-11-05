package org.example.criteria;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.Locale;
import java.util.stream.Collectors;

public class NameCriteria implements Criteria{

    @Override
    public void criteriaUser(Results results, SearchParameters searchParameters) {
        if(searchParameters.getName() != null) {
            results.setItems(results
                    .getItems()
                    .stream()
                    .filter(person -> person.getName() .equalsIgnoreCase(searchParameters.getName()))
                    .toList()
            );
        }
    }
}
