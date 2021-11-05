package org.example.criteria;


import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class AgeFromCriteria implements Criteria{

    @Override
    public void criteriaUser(Results results, SearchParameters searchParameters) {
        results.setItems(results
                .getItems()
                .stream()
                .filter(person -> person.getAge()>= searchParameters.getAgeFrom())
                .toList()
        );
    }
}
