package org.example.validators.rules;

import org.example.annotations.NotNull;

import java.lang.reflect.Field;

public class NotNullValidationRule extends ValidationRule{

    protected String getMessage(Field field) {
        NotNull notNull = field.getAnnotation(NotNull.class);
        return notNull.message();

    }

    protected boolean passRule(Field field, Object obj) throws IllegalAccessException {
        return field.get(obj)!=null;
    }

    protected boolean hasAnnotation(Field field) {
        return field.isAnnotationPresent(NotNull.class);
    }
}
