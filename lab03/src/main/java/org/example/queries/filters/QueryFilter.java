package org.example.queries.filters;

import org.example.model.Person;

import java.util.List;
import java.util.stream.Stream;

public interface QueryFilter {
    List<Person> filter(final List<Person> people);

    default QueryFilter and(final QueryFilter second) {
        return people -> second.filter(this.filter(people));
    }

    default QueryFilter or(final QueryFilter second) {
        return people -> Stream.of(this.filter(people), second.filter(people))
                .flatMap(List::stream)
                .distinct()
                .toList();
    }
}
