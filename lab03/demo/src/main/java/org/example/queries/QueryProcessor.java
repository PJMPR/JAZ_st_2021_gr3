package org.example.queries;

import org.example.filters.*;
import org.example.model.People;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.Functions;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class QueryProcessor {
    public Results GetResults(SearchParameters parameters){
        Results results = new Results();
        results.setItems(People.Data);

        List<FiltrationCriteria> records = List.of(
                new NameFilter(parameters.getName()),
                new SurnameFilter(parameters.getSurname()),
                new GenderFilter(parameters.getSelectedGenders()),
                new AgeFilter(parameters.getAgeFrom(), parameters.getAgeTo()),
                new IncomeFilter(parameters.getIncomeFrom(), parameters.getIncomeTo()),
                new PageFilter(parameters.getPage())
        );
        records.forEach(record -> record.Filtration(results));


        //Zabrakło czasu
        Functions functions = new Functions(results, "Age");
        System.out.println(functions.Do(Funcs.AVERAGE));
        functions.Do(Funcs.AVERAGE);


        return results;
    }
}
