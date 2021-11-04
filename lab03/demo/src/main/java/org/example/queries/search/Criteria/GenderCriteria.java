package org.example.queries.search.Criteria;


import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;


public class GenderCriteria implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {
        return parameters.getSelectedGenders().isEmpty() ? persons : persons.stream().filter(person -> parameters.getSelectedGenders().contains(person.getGender())).toList();
    }
}
