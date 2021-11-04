package org.example.parameters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public abstract class ParameterSet {

    public static void parameter(Results results, SearchParameters params) {
        AgeFrom.ageFrom(results, params);
        AgeTo.ageTo(results, params);
        Gender.gender(results, params);
        IncomeFrom.incomeFrom(results, params);
        IncomeTo.incomeTo(results, params);
        Name.name(results, params);
        Paging.paging(results, params);
        Surname.filterSurname(results, params);
    }
}