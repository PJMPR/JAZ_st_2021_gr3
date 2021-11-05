package org.example.queries.survive.criteria.counters;

import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;
import org.example.queries.survive.criteria.counters.math.AverageAge;
import org.example.queries.survive.criteria.counters.math.AverageIncome;
import org.example.queries.survive.criteria.counters.math.SumAge;
import org.example.queries.survive.criteria.counters.math.SumIncome;

public record CounterController(Results results, SearchParameters searchParameters) {
    public void counterMaker(){
        for(FunctionsParameters functionsParameter : searchParameters.getFunctions()){
            if(functionsParameter.getFieldName().equals("age")){
                if(functionsParameter.getFunction().equals(Funcs.AVARAGE)){
                    results.getFunctionResults().add(new AverageAge().actionResult(results));
                } else if(functionsParameter.getFunction().equals(Funcs.SUM)){
                    results.getFunctionResults().add(new SumAge().actionResult(results));
                }
            }else if(functionsParameter.getFieldName().equals("income")){
                if(functionsParameter.getFunction().equals(Funcs.AVARAGE)){
                    results.getFunctionResults().add(new AverageIncome().actionResult(results));
                } else if(functionsParameter.getFunction().equals(Funcs.SUM)){
                    results.getFunctionResults().add(new SumIncome().actionResult(results));
                }
            }
        }
    }
}
