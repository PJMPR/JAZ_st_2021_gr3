package org.example.parameters;

import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import java.util.Objects;

public class Surname extends Parameters {
    public static void filterSurname(Results results, SearchParameters params) {
        if (params.getSurname()!=null && !Objects.equals(params.getSurname(), ""))
            results.setItems(getPersonsStream(results).filter(x->x.getSurname().equalsIgnoreCase(params.getSurname())).toList());
    }
}