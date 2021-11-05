package org.example.queries.Criteria;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class IncomeFromCriteria implements Criteria{

    @Override
    public void meetCriteria(Results results, SearchParameters searchParameters) {
        results.setItems(results.getItems().stream()
                .filter(person -> person.getIncome() >= searchParameters.getIncomeFrom())
                .toList());
    }
}
