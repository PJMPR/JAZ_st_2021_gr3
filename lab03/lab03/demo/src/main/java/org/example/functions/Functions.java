package org.example.functions;

import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Functions {

    public void all(Results results, SearchParameters searchParameters){
        List<FunctionResult> functionResults = new ArrayList<>();
        for (FunctionsParameters f : searchParameters.getFunctions()) {
            if (f.getFunction() == Funcs.SUM) {
                if (Objects.equals(f.getFieldName(), "age")) {
                }
                if (Objects.equals(f.getFieldName(), "income")) {
                    functionResults.add(sumIncome(results, searchParameters));
                }

            } else if (f.getFunction() == Funcs.AVARAGE) {
                if (Objects.equals(f.getFieldName(), "age")) {
                    functionResults.add(avgAge(results, searchParameters));
                }
                if (Objects.equals(f.getFieldName(), "income")) {
                    functionResults.add(avgIncome(results, searchParameters));
                }
            }
        }
        results.setFunctionResults(functionResults);
    }



    public FunctionResult avgIncome(Results results, SearchParameters searchParameters) {
        FunctionResult functionResult = new FunctionResult();
        functionResult.setFunction(Funcs.AVARAGE);
        functionResult.setFieldName("age");
        functionResult.setValue(results.getItems().stream()
                .collect(Collectors.averagingInt(Person::getAge)));
        return functionResult;
    }

    public FunctionResult avgAge(Results results, SearchParameters searchParameters) {
        FunctionResult functionResult = new FunctionResult();
        functionResult.setFunction(Funcs.AVARAGE);
        functionResult.setFieldName("income");
        functionResult.setValue(results
                .getItems().stream()
                .collect(Collectors.averagingDouble(Person::getIncome)));
        return functionResult;
    }
    public FunctionResult sumIncome(Results results, SearchParameters searchParameters){
        FunctionResult functionResult = new FunctionResult();
        functionResult.setFunction(Funcs.SUM);
        functionResult.setFieldName("income");
        functionResult.setValue(results
                .getItems()
                .stream()
                .mapToDouble(Person::getIncome)
                .sum());
        return functionResult;


    }
    public FunctionResult sumAge(Results results){
        FunctionResult functionResult = new FunctionResult();
        functionResult.setFunction(Funcs.SUM);
        functionResult.setValue(results.getItems().stream()
                        .mapToDouble(Person::getAge)
                        .sum());

        return functionResult;
    }

}
