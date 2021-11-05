package org.example.queries.functions;

import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;

public class AvgAge {
    public FunctionResult score(Results results){
        double sum = 0;
        double elements = 0;
        for (Person person: results.getItems()){
            sum += person.getAge();
            elements += 1;
        }
        return new FunctionResult(Funcs.AVARAGE, "age", sum/elements);
    }
}
