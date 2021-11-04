package org.example.queries.search.Criteria;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;

public interface Criteria {
    List<Person> meetCriteria(List<Person> persons, SearchParameters parameters);
}