package org.example.queries.criterias;

import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class AgeCriteria implements PersonCriteria {

    @Override
    public List<Person> meetCriteria(Results results, SearchParameters pars) {
        PersonRecord personRecord = new PersonRecord(results, pars);
        List<Person> people = new ArrayList<>();
        if (pars.getAgeTo() == 0 && pars.getAgeFrom() == 0) {
            return personRecord.persons();
        }
        for (Person person : personRecord.persons()) {
            if (person.getAge() <= pars.getAgeTo() && person.getAge() >= pars.getAgeFrom()) {
                people.add(person);
            }
        }
        return people;
    }
}
