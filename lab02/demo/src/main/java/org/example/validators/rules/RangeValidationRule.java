package org.example.validators.rules;

import org.example.annotations.Range;

import java.lang.reflect.Field;

public class RangeValidationRule extends ValidationRule {


    protected String getMessage(Field field) {
        Range range = field.getAnnotation(Range.class);
        return range.message().formatted(range.min(), range.max());

    }

    protected boolean passRule(Field field, Object obj) throws IllegalAccessException {
        Range range = field.getAnnotation(Range.class);
        Number number = (Number) field.get(obj);
        return range.min()<number.doubleValue()&&number.doubleValue()<range.max();
    }

    protected boolean hasAnnotation(Field field) {
        return field.isAnnotationPresent(Range.class);
    }
}
