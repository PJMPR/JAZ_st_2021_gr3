package org.example.queries.survive.criteria.counters.math;

import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.survive.criteria.counters.CountersInterface;

public class SumAge implements CountersInterface {
    @Override
    public FunctionResult actionResult(Results results) {
        int sum = 0;
        for (Person person: results.getItems()){
            sum += person.getAge();
        }
        return new FunctionResult(Funcs.SUM, "age", sum);
    }
}
