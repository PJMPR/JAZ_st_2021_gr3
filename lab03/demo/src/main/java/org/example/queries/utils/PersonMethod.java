package org.example.queries.utils;

import org.example.model.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PersonMethod {
    private final Method base;

    public PersonMethod(final Method base) {
        this.base = base;
    }

    public Double getAsDouble(final Person object) {
        return this.getAsNumber(object).doubleValue();
    }

    private Number getAsNumber(final Person object) {
        return (Number) this.getAsObject(object);
    }

    public Enum<?> getAsEnum(final Person person) {
        return (Enum<?>) this.getAsObject(person);
    }

    public Object getAsObject(final Person object) {
        try {
            return this.base.invoke(object);
        } catch (InvocationTargetException | IllegalAccessException exception) {
            exception.printStackTrace();
            return null;
        }
    }
}
