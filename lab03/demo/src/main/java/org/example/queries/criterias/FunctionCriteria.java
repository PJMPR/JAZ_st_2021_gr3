package org.example.queries.criterias;

import org.example.queries.functions.AvgAge;
import org.example.queries.functions.AvgIncome;
import org.example.queries.functions.SumAge;
import org.example.queries.functions.SumIncome;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;


public class FunctionCriteria{
    public void functionsGetter(Results results, SearchParameters pars){
        for(FunctionsParameters functionsParameters: pars.getFunctions()){
            if(functionsParameters.getFieldName().equals("income")){
                if(functionsParameters.getFunction().equals(Funcs.AVARAGE)){
                    results.getFunctionResults().add(new AvgIncome().score(results));
                }
                if(functionsParameters.getFunction().equals(Funcs.SUM)){
                    results.getFunctionResults().add(new SumIncome().score(results));
                }
            }
            if(functionsParameters.getFieldName().equals("age")){
                if(functionsParameters.getFunction().equals(Funcs.AVARAGE)){
                    results.getFunctionResults().add(new AvgAge().score(results));
                }
                if(functionsParameters.getFunction().equals(Funcs.SUM)){
                    results.getFunctionResults().add(new SumAge().score(results));
                }
            }
        }
    }
}
