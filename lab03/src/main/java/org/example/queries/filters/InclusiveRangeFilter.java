package org.example.queries.filters;

import org.example.model.Person;
import org.example.queries.utils.PersonMethod;
import org.example.queries.utils.PersonMethodGetter;

import java.util.List;

public abstract class InclusiveRangeFilter implements QueryFilter {
    protected final Double minimumInclusive;
    protected final Double maximumInclusive;
    protected final PersonMethod targetMethod;

    public InclusiveRangeFilter(final Number minimumInclusive, final Number maximumInclusive, final String getter) {
        this.minimumInclusive = minimumInclusive.doubleValue();
        this.maximumInclusive = maximumInclusive.doubleValue();
        this.targetMethod = PersonMethodGetter.getExtendedMethod(getter);
    }

    @Override
    public List<Person> filter(final List<Person> people) {
        return people.stream()
                .filter(person -> targetMethod.getAsDouble(person) >= minimumInclusive)
                .filter(person -> targetMethod.getAsDouble(person) <= maximumInclusive)
                .toList();
    }
}
