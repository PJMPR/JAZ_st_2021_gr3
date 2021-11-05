package org.example.queries.filters.operators;

import org.example.model.Person;
import org.example.queries.filters.Filter;

import java.util.List;

public class AndFilter implements Filter {

    private final Filter filter;
    private final Filter otherFilter;

    public AndFilter(Filter filter, Filter otherFilter) {
        this.filter = filter;
        this.otherFilter = otherFilter;
    }

    @Override
    public List<Person> filter(List<Person> people) {

        List<Person> firstFilterPeople = filter.filter(people);
        return otherFilter.filter(firstFilterPeople);
    }
}
