package org.example.queries.survive.criteria;

import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;
import org.example.queries.survive.SurviveHelper;
import org.example.queries.survive.SurvivorInterface;

import java.util.ArrayList;
import java.util.List;

public class SurviveBySurname implements SurvivorInterface {
    @Override
    public List<Person> doSelection(SearchParameters searchParameters, Results results) {
        SurviveHelper surviveHelper = new SurviveHelper(searchParameters, results);
        List<Person> survivors = new ArrayList<>();

        if(searchParameters.getSurname() == null){
            return surviveHelper.getPersons();
        }

        for(Person person: surviveHelper.getPersons()){
            if(surviveHelper.isSurname(person)){
                survivors.add(person);
            }
        }
        return survivors;
    }
}
