package org.example.validators;

import org.example.annotations.Range;

import java.lang.reflect.Field;

class RangeValidator {
    public static <TClass> boolean isValid(TClass object, Field field) {
        boolean isValid = false;
        Range annotation = (Range) field.getAnnotation(Range.class);
        field.setAccessible(true);
        try {
            int value = (int) field.get(object);
            isValid = value >= annotation.min() && value <= annotation.max();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
