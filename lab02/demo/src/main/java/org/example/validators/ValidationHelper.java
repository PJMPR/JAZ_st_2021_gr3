package org.example.validators;

import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ValidationHelper {

    private final Object object;
    private final Field field;

    public ValidationHelper(Object object, Field field) {
        this.object = object;
        this.field = field;
    }

    // @NotNull helper
    private boolean isFieldIsNull() throws IllegalAccessException {
        return field.get(object) == null;
    }

    public String returnNotNullMessage(){
        return field.getAnnotation(NotNull.class).message();
    }

    public String returnRegexMessage(){
        return field.getAnnotation(Regex.class).message();
    }

    public String returnRangeMessage(){
        return field.getAnnotation(Range.class).message();
    }

    private int getMaxFromRange(){
        return field.getAnnotation(Range.class).max();
    }

    private int getMinFromRange(){
        return field.getAnnotation(Range.class).min();
    }

    // @Regex helper
    private boolean isMatchesToPattern() throws IllegalAccessException {
        return ((String) field.get(object)).matches(field.getDeclaredAnnotation(Regex.class).pattern());
    }

    // Is between following numbers
    private boolean isBetween(int start, int stop) throws IllegalAccessException {
        return ((Integer) field.get(object) <= stop && (Integer) field.get(object) >= start);
    }

    public boolean notNullCheck() throws IllegalAccessException {
        return  (field.isAnnotationPresent(NotNull.class) && isFieldIsNull());
    }

    public boolean regexCheck() throws IllegalAccessException {
        return (field.isAnnotationPresent(Regex.class) && isMatchesToPattern());
    }

    public boolean rangeCheck() throws IllegalAccessException {
        return (field.isAnnotationPresent(Range.class) && isBetween(getMinFromRange(), getMaxFromRange()));
    }
}
