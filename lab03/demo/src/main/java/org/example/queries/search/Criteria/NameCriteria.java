package org.example.queries.search.Criteria;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class NameCriteria implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> persons, SearchParameters parameters) {
        return parameters.getName() == null ? persons : persons.stream().filter(person -> person.getName().equalsIgnoreCase(parameters.getName())).toList();
    }
}
