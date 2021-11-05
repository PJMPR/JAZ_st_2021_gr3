package org.example.queries.survive;

import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public interface SurvivorInterface {
    List<Person> doSelection(SearchParameters searchParameters, Results results);
}
