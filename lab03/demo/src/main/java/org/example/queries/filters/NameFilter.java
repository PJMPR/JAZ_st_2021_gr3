package org.example.queries.filters;

import org.example.model.Person;

import java.util.List;

public class NameFilter implements Filter {
    private final String name;

    public NameFilter(String name) {
        this.name = name;
    }

    @Override
    public List<Person> filter(List<Person> people) {
        if (name != null) {
            return people.stream()
                    .filter(person -> person.getName().equalsIgnoreCase(name))
                    .toList();
        }
        return people;
    }
}
