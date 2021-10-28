package org.example.validators;

import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class AnnotationValidator extends ValidationResult{
    private Field actualField;

    public void setActualField(Field actualField) {
        this.actualField = actualField;
    }

    public void validateNotNull() throws IllegalAccessException {
        if (actualField.get(getValidatedObject()) == null) {
            addToNotValidFieldList(actualField);
            addMessage(actualField.getAnnotation(NotNull.class).message());
            setValid(false);
        }
    }

    public void validateRegex() throws IllegalAccessException {
        if (!actualField.get(getValidatedObject()).toString().matches(actualField.getAnnotation(Regex.class).pattern())) {
            addToNotValidFieldList(actualField);
            addMessage(actualField.getAnnotation(Regex.class).message());
            setValid(false);
        }
    }

    public void validateRange() throws IllegalAccessException {
        int max = actualField.getAnnotation(Range.class).max();
        int min = actualField.getAnnotation(Range.class).min();
        int value = (Integer) actualField.get(getValidatedObject());

        if (value > max || value < min) {
            addToNotValidFieldList(actualField);
            addMessage("number is out of range [" + min + "," + max + "]");
            setValid(false);
        }
    }

    public void addMessage(String message){
        getNotValidFields().get(actualField.getName()).add(message);
    }

    public void addToNotValidFieldList(Field field){
        if (!getNotValidFields().containsKey(field.getName())) {
            getNotValidFields().put(field.getName(), new ArrayList<>());
        }
    }
}
