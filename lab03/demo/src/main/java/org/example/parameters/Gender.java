package org.example.parameters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class Gender extends Parameters {
    public static void gender(Results results, SearchParameters params) {
        if (!params.getSelectedGenders().isEmpty())
            results.setItems(getPersonsStream(results).filter(x->(params.getSelectedGenders().contains(x.getGender()))).toList());
    }
}