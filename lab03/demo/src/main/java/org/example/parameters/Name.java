package org.example.parameters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import java.util.Objects;

public class Name extends Parameters {
    public static void name(Results results, SearchParameters params) {
        if (params.getName()!=null && !Objects.equals(params.getName(), ""))
            results.setItems(getPersonsStream(results).filter(x -> x.getName().equalsIgnoreCase(params.getName())).toList());
    }
}