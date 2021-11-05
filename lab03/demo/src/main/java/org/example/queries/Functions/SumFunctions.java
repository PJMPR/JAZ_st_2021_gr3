package org.example.queries.Functions;

import org.example.model.Person;
import org.example.queries.Criteria.Criteria;
import org.example.queries.results.Results;
import org.example.queries.search.Funcs;
import org.example.queries.search.FunctionsParameters;
import org.example.queries.search.SearchParameters;

import java.util.List;
import java.util.stream.Collectors;

public class SumFunctions implements Criteria {
    @Override
    public void meetCriteria(Results results, SearchParameters searchParameters) {
        ListsFunctions listsFunctions = new ListsFunctions();

        List<FunctionsParameters> functionsParametersList = searchParameters.getFunctions().stream()
                .filter(functionsParameters -> functionsParameters.getFunction().equals(Funcs.SUM))
                .collect(Collectors.toList());

        for (FunctionsParameters functionsParameters : functionsParametersList){
            if(functionsParameters.getFieldName().equals("income")){
                listsFunctions.setSum(results.getItems().stream()
                        .mapToDouble(Person::getIncome)
                        .sum());
            } else if(functionsParameters.getFieldName().equals("age")){
                listsFunctions.setSum(results.getItems().stream()
                        .mapToDouble(Person::getAge)
                        .sum());
            }
            results.getFunctionResults().add(listsFunctions.getFunctionResult());
        }
    }
}
