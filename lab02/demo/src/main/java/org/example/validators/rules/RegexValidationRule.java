package org.example.validators.rules;

import org.example.annotations.Regex;

import java.lang.reflect.Field;

public class RegexValidationRule extends  ValidationRule{

    protected String getMessage(Field field) {
        Regex regex = field.getAnnotation(Regex.class);
        return regex.message();

    }

    protected boolean passRule(Field field, Object obj) throws IllegalAccessException {
        Regex regex=field.getAnnotation(Regex.class);
        String value = (String) field.get(obj);
        return value.matches(regex.pattern());
    }

    protected boolean hasAnnotation(Field field) {
        return field.isAnnotationPresent(Regex.class);
    }
}
