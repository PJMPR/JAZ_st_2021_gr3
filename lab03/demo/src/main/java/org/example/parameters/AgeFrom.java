package org.example.parameters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class AgeFrom extends Parameters {
    public static void ageFrom(Results results, SearchParameters params) {
        if (params.getAgeFrom()!=0) results.setItems(getPersonsStream(results).filter(x->x.getAge()>=params.getAgeFrom()).toList());
    }
}