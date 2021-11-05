package org.example.queries.functions;

import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;

public class SumIncome {
    public FunctionResult score(Results results){
        double sum = 0;
        for (Person person: results.getItems()){
            sum += person.getIncome();
        }
        return new FunctionResult(Funcs.SUM, "income", sum);
    }
}
