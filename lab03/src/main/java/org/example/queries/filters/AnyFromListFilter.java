package org.example.queries.filters;

import org.example.model.Person;
import org.example.queries.utils.PersonMethod;
import org.example.queries.utils.PersonMethodGetter;

import java.util.List;

public abstract class AnyFromListFilter implements QueryFilter {
    protected final List<?> appropriateValues;
    protected final PersonMethod targetMethod;

    public AnyFromListFilter(final List<?> list, final String getter) {
        this.appropriateValues = list;
        this.targetMethod = PersonMethodGetter.getExtendedMethod(getter);
    }

    @Override
    public List<Person> filter(final List<Person> people) {
        return appropriateValues.isEmpty() ? people :
        people.stream()
                .filter(person -> appropriateValues.contains(targetMethod.getAsObject(person)))
                .toList();
    }
}
