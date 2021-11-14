package org.example.criteria;

import org.example.model.People;
import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class CriteriaName implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> personList, SearchParameters parameters) {
        return personList.stream()
                .filter(person -> person.getName().equalsIgnoreCase(parameters.getName()))
                .toList();
    }
}
