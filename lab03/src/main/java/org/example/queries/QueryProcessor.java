package org.example.queries;

import org.example.model.People;
import org.example.queries.filters.*;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import org.example.queries.utils.PersonFieldGetter;

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
            .map(functionsParameters -> {
                final var fieldValuesStream = items.stream()
                    .map(person -> PersonFieldGetter.getFieldValueAsNumber(functionsParameters.getFieldName(), person))
                    .mapToDouble(number -> number.doubleValue());
                    // When .mapToDouble(Number::doubleValue); used:
                    // java: incompatible types: invalid method reference
                    //    method doubleValue in class java.lang.Number cannot be applied to given types
                    //      required: no arguments
                    //      found:    java.lang.Object
                    //      reason: actual and formal argument lists differ in length
                return new FunctionResult(
                    functionsParameters.getFunction(),
                    functionsParameters.getFieldName(),
                    switch (functionsParameters.getFunction()) {
                        case SUM -> fieldValuesStream.sum();
                        case AVARAGE -> fieldValuesStream.average().orElse(0);
                    }
                );
            })
            .toList();

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
