package org.example.queries.criterias;

import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.List;

public record PersonRecord(Results results, SearchParameters pars) {

    public List<Person> persons(){
        return results.getItems();
    }
}
