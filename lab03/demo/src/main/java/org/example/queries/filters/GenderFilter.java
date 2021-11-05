package org.example.queries.filters;

import org.example.model.Gender;
import org.example.model.Person;

import java.util.List;

public class GenderFilter implements Filter {
    private final List<Gender> gender;

    public GenderFilter(List<Gender> gender) {
        this.gender = gender;
    }

    @Override
    public List<Person> filter(List<Person> people) {
        if (!gender.isEmpty()) {
            return people.stream()
                    .filter(person -> gender.contains(person.getGender()))
                    .toList();
        }
        return people;
    }
}
