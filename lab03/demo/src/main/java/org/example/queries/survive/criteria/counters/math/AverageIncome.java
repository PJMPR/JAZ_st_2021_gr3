package org.example.queries.survive.criteria.counters.math;

import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.survive.criteria.counters.CountersInterface;

public class AverageIncome implements CountersInterface {
    @Override
    public FunctionResult actionResult(Results results) {
        int totalSum = 0;
        for(Person person: results.getItems()){
            totalSum += person.getIncome();
        }
        return new FunctionResult(Funcs.AVARAGE, "income", totalSum/results.getFunctionResults().size());
    }
}
