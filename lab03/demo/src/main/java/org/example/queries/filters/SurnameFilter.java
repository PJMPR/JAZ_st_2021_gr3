package org.example.queries.filters;

import org.example.model.Person;

import java.util.List;

public class SurnameFilter implements Filter {
    private final String surname;

    public SurnameFilter(String surname) {
        this.surname = surname;
    }

    @Override
    public List<Person> filter(List<Person> people) {
        if (surname != null) {
            return people.stream()
                    .filter(person -> person.getName().equalsIgnoreCase(surname))
                    .toList();
        }
        return people;
    }
}
