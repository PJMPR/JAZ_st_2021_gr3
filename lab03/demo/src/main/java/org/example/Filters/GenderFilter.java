package org.example.Filters;

import org.example.model.Gender;
import org.example.model.Person;
import org.example.queries.results.Results;

import java.util.List;
import java.util.stream.Collectors;

public class GenderFilter {

    public void meetCriteria(Results results, List<Gender> genderList) {

        List<Person> tempList = results.getItems().stream()
                .filter(person -> genderList.contains(person.getGender()))
                .collect(Collectors.toList());
        results.setItems(tempList);

    }
}
