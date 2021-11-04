package org.example.queries.search.Criteria;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class MinAgeCriteria implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {
        return persons.stream().filter(person -> person.getAge() > parameters.getAgeFrom()).toList();
    }
}
