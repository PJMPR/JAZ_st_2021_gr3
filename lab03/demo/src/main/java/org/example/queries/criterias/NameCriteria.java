package org.example.queries.criterias;

import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class NameCriteria implements PersonCriteria {

    @Override
    public List<Person> meetCriteria(Results results, SearchParameters pars) {
        PersonRecord personRecord = new PersonRecord(results, pars);
        List<Person> people = new ArrayList<Person>();
        if(pars.getName() == null){
            return personRecord.persons();
        }
        for(Person person: personRecord.persons()){
            if(person.getName().equals(pars.getName())){
                people.add(person);
            }
        }
        return people;
    }
}