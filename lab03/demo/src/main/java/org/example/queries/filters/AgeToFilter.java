package org.example.queries.filters;

import org.example.model.Person;

import java.util.List;

public class AgeToFilter implements Filter {
    private final int number;

    public AgeToFilter(int number) {
        this.number = number;
    }

    @Override
    public List<Person> filter(List<Person> people) {
        if (number > 0) {
            return people.stream()
                    .filter(person -> person.getAge() <= number)
                    .toList();
        }
        return people;
    }
}
