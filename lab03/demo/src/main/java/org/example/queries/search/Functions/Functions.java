package org.example.queries.search.Functions;

import org.example.model.Person;
import org.example.queries.search.FunctionsParameters;

import java.util.List;

public interface Functions {
    double doSth(List<Person> persons, FunctionsParameters functionsParameters);
}
