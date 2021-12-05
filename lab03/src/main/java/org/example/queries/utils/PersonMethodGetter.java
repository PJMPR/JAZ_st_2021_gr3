package org.example.queries.utils;

import org.example.model.Person;

import java.lang.reflect.Method;

public class PersonMethodGetter {

    public static PersonMethod getExtendedMethod(final String name) {
        return new PersonMethod(PersonMethodGetter.getReflectedMethod(name));
    }

    private static Method getReflectedMethod(final String name) {
        try {
            return Person.class.getDeclaredMethod(name);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}
