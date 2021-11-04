package org.example.functions;

import java.util.Objects;

import org.example.model.Person;
import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;

public class Functions {
    public void executeFunction(Results results, SearchParameters searchParameters) {
        for (FunctionsParameters function : searchParameters.getFunctions()) {
            if (isSumOfAge(function)) results.getFunctionResults().add(sumAge(results));
            else if (isSumOfIncome(function)) results.getFunctionResults().add(sumIncome(results));
            else if (isAverageOfAge(function)) results.getFunctionResults().add(averageAge(results));
            else if (isAverageOfIncome(function)) results.getFunctionResults().add(averageIncome(results));
        }
    }

    private boolean isSumFunction(FunctionsParameters function) { return function.getFunction() == Funcs.SUM; }
    private boolean isSumOfAge(FunctionsParameters function) { return isSumFunction(function) && Objects.equals(function.getFieldName(), "age"); }
    private boolean isSumOfIncome(FunctionsParameters function) { return isSumFunction(function) && Objects.equals(function.getFieldName(), "income"); }
    private boolean isAverageFunction(FunctionsParameters function) { return function.getFunction() == Funcs.AVARAGE; }
    private boolean isAverageOfAge(FunctionsParameters function) { return isAverageFunction(function) && Objects.equals(function.getFieldName(), "age"); }
    private boolean isAverageOfIncome(FunctionsParameters function) { return isAverageFunction(function) && Objects.equals(function.getFieldName(), "income"); }

    private double calculateAverageAge(Results result) {
        return result.getItems().stream().mapToDouble(Person::getAge).average().orElse(Double.NaN);
    }

    protected FunctionResult averageAge(Results results) {
        return new FunctionResult(calculateAverageAge(results));
    }

    private double calculateAverageIncome(Results result) {
        return result.getItems().stream().mapToDouble(Person::getIncome).average().orElse(Double.NaN);
    }

    protected FunctionResult averageIncome(Results results) {
        return new FunctionResult(calculateAverageIncome(results));
    }

    private double calculateSumAge(Results result) {
        return result.getItems().stream().mapToDouble(Person::getIncome).sum();
    }

    protected FunctionResult sumAge(Results results) {
        return new FunctionResult(calculateSumAge(results));
    }

    private double calculateSumIncome(Results result) {
        return result.getItems().stream().mapToDouble(Person::getIncome).sum();
    }

    protected FunctionResult sumIncome(Results results) {
        return new FunctionResult(calculateSumIncome(results));
    }
}