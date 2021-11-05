package org.example.criteria;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.stream.Collectors;

public class IncomeToCriteria implements Criteria{

    @Override
    public void criteriaUser(Results results, SearchParameters searchParameters) {
        results.setItems(results
            .getItems()
            .stream()
            .filter(person -> person.getIncome()<= searchParameters.getIncomeTo())
            .toList()
        );
    }
}
