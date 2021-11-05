package org.example.filters;

import org.example.model.Gender;
import org.example.model.Person;
import org.example.queries.results.Results;

import java.util.List;
import java.util.stream.Collectors;

public record GenderFilter(List<Gender> sex) implements FiltrationCriteria {

    @Override
    public void Filtration(Results results) {
        if (sex.size() > 0) {
                List<Person> gen = results.getItems().stream()
                        .filter(p -> sex.contains(p.getGender()))
                        .collect(Collectors.toList());
                results.setItems(gen);
        }
    }
}
