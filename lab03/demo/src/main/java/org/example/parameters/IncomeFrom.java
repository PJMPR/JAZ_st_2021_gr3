package org.example.parameters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class IncomeFrom extends Parameters {
    public static void incomeFrom(Results results, SearchParameters params) {
        if (params.getIncomeFrom()!=0)results.setItems(getPersonsStream(results).filter(x->x.getIncome()>=params.getIncomeFrom()).toList());
    }
}