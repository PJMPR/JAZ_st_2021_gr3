package org.example.Filters;

import org.example.model.Person;
import org.example.queries.results.Results;

import java.util.List;
import java.util.stream.Collectors;

public class SurnameFIlter implements FilterPattern{
    @Override
    public void meetCriteria(Results results, String string) {

        List<Person> tempList = results.getItems().stream()
                .filter(person -> person.getSurname().equalsIgnoreCase(string))
                .collect(Collectors.toList());
        results.setItems(tempList);

    }
}
