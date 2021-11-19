package org.example.queries.Filters;

import org.example.model.Person;

import java.util.List;
import java.util.Locale;

public class NameFilter implements Filter{
    String NameToFit;

    public NameFilter(String name){
        this.NameToFit = name;
    }
    @Override
    public List<Person> filter(List<Person> persons) {
        if (NameToFit!=null) {
            return persons.stream().filter(person -> person.getName().toUpperCase(Locale.ROOT)
                    .equals(NameToFit.toUpperCase(Locale.ROOT))).toList();
        }
        else {
            return persons;
        }
    }
}
