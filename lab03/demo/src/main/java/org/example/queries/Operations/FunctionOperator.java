package org.example.queries.Operations;

import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionOperator {

    private FunctionResult ageAvg(Results results) {
        FunctionResult functionResult = new FunctionResult();
        functionResult.setFunction(Funcs.AVARAGE);
        functionResult.setFieldName("age");
        functionResult.setValue(
                results.getItems()
                        .stream().collect(Collectors.averagingInt(Person::getAge))
        );
        return functionResult;
    }

    private FunctionResult ageSum(Results results) {
        FunctionResult functionResult = new FunctionResult();
        functionResult.setFunction(Funcs.SUM);
        functionResult.setFieldName("age");
        functionResult.setValue(
                results.getItems()
                        .stream().mapToInt(Person::getAge).sum()
        );
        return functionResult;
    }

    private FunctionResult incomeAvg(Results results) {
        FunctionResult functionResult = new FunctionResult();
        functionResult.setFunction(Funcs.AVARAGE);
        functionResult.setFieldName("income");
        functionResult.setValue(
                results.getItems()
                        .stream().collect(Collectors.averagingDouble(Person::getIncome))
        );
        return functionResult;
    }

    private FunctionResult incomeSum(Results results) {
        FunctionResult functionResult = new FunctionResult();
        functionResult.setFunction(Funcs.SUM);
        functionResult.setFieldName("income");
        functionResult.setValue(
                results.getItems()
                        .stream().mapToDouble(Person::getIncome).sum()
        );
        return functionResult;
    }

    public void getResults(SearchParameters searchParameters, Results results) {
        List<FunctionResult> functionResults = new ArrayList<>();

        for (FunctionsParameters functionsParameters : searchParameters.getFunctions()) {
            if (functionsParameters.getFunction() == Funcs.SUM) {
                switch (functionsParameters.getFieldName()) {
                    case "age" -> functionResults.add(ageSum(results));
                    case "income" -> functionResults.add(incomeSum(results));
                }
            } else if (functionsParameters.getFunction() == Funcs.AVARAGE) {
                switch (functionsParameters.getFieldName()) {
                    case "age" -> functionResults.add(ageAvg(results));
                    case "income" -> functionResults.add(incomeAvg(results));
                }
            }

        }
        results.setFunctionResults(functionResults);
    }
}
