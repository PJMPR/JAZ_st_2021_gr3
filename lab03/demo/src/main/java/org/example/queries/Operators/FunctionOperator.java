package org.example.queries.Operators;

import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class FunctionOperator extends FunctionCases {

    public void operateFunctions(SearchParameters searchParameters, Results results){
        List<FunctionResult> functionResults = new ArrayList<>();

        for (FunctionsParameters functionsParameters : searchParameters.getFunctions()){
                if (functionsParameters.getFunction()== Funcs.SUM){
                    switch (functionsParameters.getFieldName()){
                        case "age" -> functionResults
                                .add(new FunctionCases().ageSum(results));
                        case "income" -> functionResults
                                .add(new FunctionCases().incomeSum(results));
                    }
                }
                else if(functionsParameters.getFunction()== Funcs.AVARAGE) {
                    switch (functionsParameters.getFieldName()){
                        case "age" -> functionResults
                                .add(new FunctionCases().ageAvg(results));
                        case "income" -> functionResults
                                .add(incomeAvg(results));
                    }
                }

            };
            results.setFunctionResults(functionResults);
    }
}

