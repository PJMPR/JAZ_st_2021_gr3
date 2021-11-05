package org.example.functions;

import org.example.queries.results.FunctionResult;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;


public class functionsArrayList {

    functions calcs = new functions();

    public void functionsAddTo(SearchParameters searchParameters, Results results){
        List<FunctionResult> functionResults = new ArrayList<>();
        for(FunctionsParameters f : searchParameters.getFunctions()){
            if (f.getFunction() == Funcs.AVARAGE) {
                switch (f.getFieldName()){
                    case "age" ->
                            functionResults.add(calcs.avgAge(results));
                    case "income" ->
                            functionResults.add(calcs.avgIncome(results));
                }

            }
            else if (f.getFunction() == Funcs.SUM){
                switch (f.getFieldName()){
                    case "age" ->
                            functionResults.add(calcs.sumAge(results));
                    case "income" ->
                            functionResults.add(calcs.sumIncome(results));
                }
            }
        }
        results.setFunctionResults(functionResults);
    }
}
