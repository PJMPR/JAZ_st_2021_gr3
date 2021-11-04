package org.example.parameters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class AgeTo extends Parameters {
    public static void ageTo(Results results, SearchParameters params) {
        if (params.getAgeTo()!=0) results.setItems(getPersonsStream(results).filter(x->x.getAge()<=params.getAgeTo()).toList());
    }
}