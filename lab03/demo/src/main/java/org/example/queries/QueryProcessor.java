package org.example.queries;

import org.example.model.People;
import org.example.model.Person;
import org.example.queries.Filters.*;
import org.example.queries.Operators.FunctionOperator;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import java.util.List;


public class QueryProcessor {


    public Results GetResults(SearchParameters parameters){
        Results result = new Results();

        result.setItems(People.Data);

        List<Filter> filters = List.of(
                new NameFilter(parameters.getName()),
                new SurnameFilter(parameters.getSurname()),
                new AgeFilter(parameters.getAgeFrom(), parameters.getAgeTo()),
                new EarningsFilter(parameters.getIncomeFrom(), parameters.getIncomeTo()),
                new GenderFilter(parameters.getSelectedGenders()),
                new PageFilter(parameters.getPage(),result)
        );
        filters.stream().forEach(filter -> {
                result.setItems(filter.filter(result.getItems()));
        });

        PageFilter pagesett = new PageFilter(parameters.getPage(),result);
        result.setPages(pagesett.setpageResoults().getPages());
        result.setCurrentPage(pagesett.setpageResoults().getCurrentPage());

        FunctionOperator functionOperator = new FunctionOperator();
        functionOperator.operateFunctions(parameters,result);


        return result;
    }

}
