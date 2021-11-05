package org.example.queries;

import org.example.model.People;
import org.example.model.Person;
import org.example.queries.criterias.*;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class QueryProcessor {

    .;

    public Results GetResults(SearchParameters pars){
        Results result = new Results();
        result.setItems(People.Data);

        List<Person> passed = new ArrayList<>();

        PersonCriteria name = new NameCriteria();
        PersonCriteria surname = new SurnameCriteria();
        PersonCriteria age = new AgeCriteria();
        PersonCriteria income = new IncomeCriteria();
        PersonCriteria gender = new GenderCriteria();

        name.meetCriteria(result,pars);
        surname.meetCriteria(result,pars);
        age.meetCriteria(result,pars);
        income.meetCriteria(result, pars);
        gender.meetCriteria(result, pars);


        FunctionCriteria functionCriteria = new FunctionCriteria();
        functionCriteria.functionsGetter(result, pars);





    return result;
    }
}
