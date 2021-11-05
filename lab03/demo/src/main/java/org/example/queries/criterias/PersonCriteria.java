package org.example.queries.criterias;

import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public interface PersonCriteria {
    List<Person> meetCriteria(Results results, SearchParameters pars);
}