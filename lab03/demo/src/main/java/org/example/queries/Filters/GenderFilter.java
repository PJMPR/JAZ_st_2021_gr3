package org.example.queries.Filters;

import org.example.model.Gender;
import org.example.model.Person;

import java.util.List;

public class GenderFilter implements Filter{
    List<Gender> gender;

    public GenderFilter(List<Gender> gender) {
        this.gender = gender;
    }

    @Override
    public List<Person> filter(List<Person> persons) {
        if (!gender.isEmpty()) {
            return persons.stream().filter(person -> gender.contains(person.getGender())).toList();
        }
        else {
            return persons;
        }
    }
}
