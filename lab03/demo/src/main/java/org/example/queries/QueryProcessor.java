package org.example.queries;

import org.example.model.People;
import org.example.queries.filters.*;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.stream.Stream;

public class QueryProcessor {

    public Results GetResults(SearchParameters parameters){

        final var combinedFilter = Stream.of(
                new AgeFilter(parameters.getAgeFrom(), parameters.getAgeTo()),
                new IncomeFilter(parameters.getIncomeFrom(), parameters.getIncomeTo()),
                new GenderListFilter(parameters.getSelectedGenders()),
                new NameFilter(parameters.getName()),
                new SurnameFilter(parameters.getSurname()),
                new PageFilter(parameters.getPage().getSize(), parameters.getPage().getPageNumber())
        ).reduce(QueryFilter::and).get();

        final var items = combinedFilter.filter(People.Data);

        final var functionResults = parameters.getFunctions().stream()
                        .map(functionsParameters -> new FunctionResult(functionsParameters.getFunction(), functionsParameters.getFieldName(), 0)).toList();

        final int pageSize = parameters.getPage().getSize();
        final double totalPeople = items.size();
        final int totalPages = (int) Math.ceil(totalPeople / pageSize);

        return new Results(
                items,
                functionResults,
                totalPages,
                parameters.getPage().getPageNumber()
        );
    }
}
