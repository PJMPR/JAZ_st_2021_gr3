package org.example.queries.filters;

import org.example.model.Person;

import java.util.List;

public class IncomeToFilter implements Filter {
    private final double number;

    public IncomeToFilter(double number) {
        this.number = number;
    }

    @Override
    public List<Person> filter(List<Person> people) {
        if (number > 0) {
            return people.stream()
                    .filter(person -> person.getIncome() <= number)
                    .toList();
        }
        return people;
    }
}
