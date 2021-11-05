package org.example.queries.criterias;

import org.example.model.Person;
import org.example.queries.results.Results;
import org.example.queries.search.SearchParameters;

import java.util.ArrayList;
import java.util.List;

public class IncomeCriteria implements PersonCriteria {

    @Override
    public List<Person> meetCriteria(Results results, SearchParameters pars) {
        PersonRecord personRecord = new PersonRecord(results, pars);
        List<Person> people = new ArrayList<>();
        if (pars.getIncomeTo() == 0 && pars.getIncomeFrom() == 0) {
            return personRecord.persons();
        }
        for (Person person : personRecord.persons()) {
            if (person.getIncome() <= pars.getIncomeTo() && person.getIncome() >= pars.getIncomeFrom()) {
                people.add(person);
            }
        }
        return people;
    }
}
