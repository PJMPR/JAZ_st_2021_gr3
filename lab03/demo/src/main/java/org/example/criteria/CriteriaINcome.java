package org.example.criteria;

import org.example.model.Person;
import org.example.queries.search.SearchParameters;

import java.util.List;

public class CriteriaINcome implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> personList, SearchParameters parameters) {
        return personList.stream()
                .filter(person -> person.getIncome() >= parameters.getIncomeFrom())
                .filter(person -> person.getIncome() <= parameters.getIncomeTo())
                .toList();
    }
}
