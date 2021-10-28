package org.example.validators;

import org.example.annotations.Regex;

import java.lang.reflect.Field;
import java.util.regex.Pattern;

class RegexValidator {
    public static <TClass> boolean isValid(TClass object, Field field) {
        boolean isValid = false;
        Regex annotation = field.getAnnotation(Regex.class);
        Pattern pattern = Pattern.compile(annotation.pattern());
        field.setAccessible(true);
        try {
            String value = (String) field.get(object);
            isValid = pattern.matcher(value).matches();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
