package org.example.queries.utils;

import org.example.model.Person;

import java.lang.reflect.Field;
import java.util.Objects;

public class PersonFieldGetter {

    public static Number getFieldValueAsNumber(final String fieldName, final Object object) {
        return (Number) PersonFieldGetter.getFieldValue(fieldName, object);
    }

    public static Object getFieldValue(final String fieldName, final Object object) {
        try {
            return Objects.requireNonNull(PersonFieldGetter.getReflectedField(fieldName)).get(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Field getReflectedField(final String name) {
        try {
            final var field = Person.class.getDeclaredField(name);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }
}
