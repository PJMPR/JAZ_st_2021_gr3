package org.example.parameters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class IncomeTo extends Parameters {
    public static void incomeTo(Results results, SearchParameters params) {
        if (params.getIncomeTo()!=0)results.setItems(getPersonsStream(results).filter(x->x.getIncome()<=params.getIncomeTo()).toList());
    }
}