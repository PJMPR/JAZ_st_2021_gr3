package org.example.queries;

import org.example.model.People;
import org.example.queries.Operations.FunctionOperator;
import org.example.queries.Operations.PageOperator;
import org.example.queries.filters.*;
import org.example.queries.filters.operators.AndFilter;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class QueryProcessor {

    public Results GetResults(SearchParameters parameters) {
        Results result = new Results();

        result.setItems(People.Data);

        List<Filter> filterList = List.of(
                new AndFilter(new AgeFromFilter(parameters.getAgeFrom()), new AgeToFilter(parameters.getAgeTo())),
                new AndFilter(new IncomeFromFilter(parameters.getIncomeFrom()), new IncomeToFilter(parameters.getIncomeTo())),
                new NameFilter(parameters.getName()),
                new SurnameFilter(parameters.getSurname()),
                new GenderFilter(parameters.getSelectedGenders())
        );
        filterList.forEach(c -> result.setItems(c.filter(result.getItems())));

        PageOperator pageOperator = new PageOperator(parameters.getPage());
        pageOperator.pageGetter(result);

        FunctionOperator functionOperator = new FunctionOperator();
        functionOperator.getResults(parameters, result);

        return result;
    }
}
