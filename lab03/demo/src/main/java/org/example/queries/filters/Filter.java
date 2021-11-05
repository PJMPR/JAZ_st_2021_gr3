package org.example.queries.filters;

import org.example.model.Person;

import java.util.List;

public interface Filter {
    List<Person> filter(final List<Person> people);
}
