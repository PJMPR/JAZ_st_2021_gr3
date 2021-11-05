package org.example.queries;

import org.example.Filters.*;
import org.example.Filters.FuncsFilter;
import org.example.model.People;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

public class QueryProcessor {

    public Results GetResults(SearchParameters parameters){
        Results result = new Results();

        result.setItems(People.Data);


        if( parameters.getName() != null){
            new NameFIlter().meetCriteria(result, parameters.getName());
        }
        if( parameters.getSurname() != null){
            new SurnameFIlter().meetCriteria(result, parameters.getSurname());
        }
        if(parameters.getAgeFrom() > 1){
            new AgeFromFilter().meetCriteria(result, String.valueOf(parameters.getAgeFrom()));
        }
        if(parameters.getAgeTo() > 1 ){
            new AgeToFIlter().meetCriteria(result, String.valueOf(parameters.getAgeTo()));
        }
        if( parameters.getIncomeFrom() > 1.0){
            new IncomeFromFilter().meetCriteria(result, String.valueOf(Math.round(parameters.getIncomeFrom())));
        }
        if( parameters.getIncomeTo() > 1.0){
            new IncomeToFilter().meetCriteria(result, String.valueOf(Math.round(parameters.getIncomeTo())));
        }
        if(! parameters.getSelectedGenders().isEmpty()){
            new GenderFilter().meetCriteria(result,parameters.getSelectedGenders());
        }
        if(! parameters.getFunctions().isEmpty()){
            new FuncsFilter().meetCriteria(result,parameters.getFunctions());
        }
        if(parameters.getPage() != null){
            new PageFilter().meetCriteria(result, parameters.getPage());
        }

        return result;
    }
}
