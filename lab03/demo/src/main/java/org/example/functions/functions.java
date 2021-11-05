package org.example.functions;

import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;

import java.util.stream.Collectors;

public class functions {

    FunctionResult functionResult = new FunctionResult();
    public FunctionResult avgAge(Results results){
        functionResult.setFunction(Funcs.AVARAGE);
        functionResult.setFieldName("age");
        functionResult.setValue(results
            .getItems()
            .stream()
            .collect(Collectors.averagingInt(Person::getAge))
        );
        return functionResult;
    }
    public FunctionResult avgIncome(Results results){
        functionResult.setFunction(Funcs.AVARAGE);
        functionResult.setFieldName("income");
        functionResult.setValue(results
            .getItems()
            .stream()
            .collect(Collectors.averagingDouble(Person::getIncome))
        );
    return functionResult;
    }

    public FunctionResult sumAge(Results results){
        functionResult.setFieldName("age");
        functionResult.setFunction(Funcs.SUM);
        functionResult.setValue(results
            .getItems()
            .stream()
            .mapToDouble(Person::getAge).sum()
        );
    return functionResult;
    }
    public FunctionResult sumIncome(Results results){
        functionResult.setFieldName("income");
        functionResult.setFunction(Funcs.SUM);
        functionResult.setValue(results
            .getItems()
            .stream()
            .mapToDouble(Person::getIncome).sum()
        );
    return functionResult;
    }


}
