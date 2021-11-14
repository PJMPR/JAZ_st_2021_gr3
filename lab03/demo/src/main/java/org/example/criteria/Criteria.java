package org.example.criteria;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;

public interface Criteria {
    public List<Person> meetCriteria(List<Person> personList, SearchParameters parameters);
}
