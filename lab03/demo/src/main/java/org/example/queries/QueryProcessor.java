package org.example.queries;

import org.example.model.People;
import org.example.functions.Functions;
import org.example.parameters.*;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import java.util.concurrent.atomic.AtomicReference;

public class QueryProcessor {

    public Results GetResults(SearchParameters parameters) {
        AtomicReference<Results> result = new AtomicReference<>(new Results());

        result.get().setItems(People.Data);
        ParameterSet.parameter(result.get(), parameters);

        Functions functions = new Functions();
        functions.executeFunction(result.get(), parameters);

        return result.get();
    }
}