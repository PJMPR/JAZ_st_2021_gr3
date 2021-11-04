package org.example.queries.search.Functions;

import org.example.model.Person;
import org.example.queries.search.FunctionsParameters;

import java.util.List;

public class Sum implements Functions{
    @Override
    public double doSth(List<Person> persons, FunctionsParameters functionsParameters) {
        double result = switch (functionsParameters.getFieldName()) {
            case "age" -> persons.stream().mapToDouble(Person::getAge).sum();
            case "income" -> persons.stream().mapToDouble(Person::getIncome).sum();
            default -> 0;
        };

        return result;
    }
}
