package org.example.queries.Filters;

import org.example.model.Person;

import java.util.List;

public interface Filter {
    List<Person> filter(List<Person> persons);
}
