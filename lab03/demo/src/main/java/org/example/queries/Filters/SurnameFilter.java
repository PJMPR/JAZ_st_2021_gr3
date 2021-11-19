package org.example.queries.Filters;

import org.example.model.Person;

import java.util.List;
import java.util.Locale;

public class SurnameFilter implements Filter {
    String SurnameToFit;

    public SurnameFilter(String surnameToFit){
        this.SurnameToFit = surnameToFit;
    }

    @Override
    public List<Person> filter(List<Person> persons) {
        if (SurnameToFit!=null) {
            return persons.stream().filter(person -> person.getName().toUpperCase(Locale.ROOT)
                    .equals(SurnameToFit.toUpperCase(Locale.ROOT))).toList();
        }
        else {
            return persons;
        }
    }
}
