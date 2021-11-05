package org.example.queries.filters;

import org.example.model.Person;

import java.util.List;

public class AgeFromFilter implements Filter {
    private final int number;

    public AgeFromFilter(int number) {
        this.number = number;
    }

    @Override
    public List<Person> filter(List<Person> people) {
        if (number > 0) {
            return people.stream()
                    .filter(person -> person.getAge() >= number)
                    .toList();
        }
        return people;
    }
}
