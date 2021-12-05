package org.example.queries.filters;

import org.example.model.Person;
import org.example.queries.utils.PersonMethod;
import org.example.queries.utils.PersonMethodGetter;

import java.util.List;

public abstract class EqualityFilter implements QueryFilter {
    protected final Object expected;
    protected final PersonMethod targetMethod;

    public EqualityFilter(final Object expected, final String getter) {
        this.expected = expected;
        this.targetMethod = PersonMethodGetter.getExtendedMethod(getter);
    }

    @Override
    public List<Person> filter(final List<Person> people) {
        return expected == null ? people :
        people.stream()
                .filter(person -> equals(expected, targetMethod.getAsObject(person)))
                .toList();
    }

    protected abstract boolean equals(final Object expected, final Object given);
}
