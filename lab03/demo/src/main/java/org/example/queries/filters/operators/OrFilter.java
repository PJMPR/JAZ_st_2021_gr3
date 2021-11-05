package org.example.queries.filters.operators;

import org.example.model.Person;
import org.example.queries.filters.Filter;

import java.util.List;

public class OrFilter implements Filter {
    private Filter filter;
    private Filter otherFilter;

    public OrFilter(Filter filter, Filter otherFilter) {
        this.filter = filter;
        this.otherFilter = otherFilter;
    }

    @Override
    public List<Person> filter(List<Person> people) {
        List<Person> firstFilterItems = filter.filter(people);
        List<Person> otherFilterItems = otherFilter.filter(people);

        for (Person person: otherFilterItems) {
            if(!firstFilterItems.contains(people)){
                firstFilterItems.add(person);
            }
        }
        return firstFilterItems;
    }
}
