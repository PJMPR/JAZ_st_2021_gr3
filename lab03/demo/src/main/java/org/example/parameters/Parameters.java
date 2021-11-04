package org.example.parameters;

import org.example.queries.results.Results;
import java.util.stream.Stream;
import org.example.model.Person;

public class Parameters {
    public static Stream<Person> getPersonsStream(Results results) { return results.getItems().stream(); }
}