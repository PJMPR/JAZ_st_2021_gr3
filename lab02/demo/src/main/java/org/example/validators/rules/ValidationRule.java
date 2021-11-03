package org.example.validators.rules;

import org.example.annotations.NotNull;
import org.example.validators.ValidationResult;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public abstract class ValidationRule implements ICheckValidationRule {
    public void ValidateRule(ValidationResult validationResult){

        if(validationResult.getValidatedObject()==null)return;
        List<Field> fields  = Arrays.stream(validationResult
                        .getValidatedObject()
                        .getClass()
                        .getDeclaredFields())
                .toList();
        fields.stream().filter(field-> hasAnnotation(field))
                .filter(field-> checkField(validationResult, field))
                .forEach(field->{
                    validationResult.setValid(false);
                    addMessage(field, validationResult.getNotValidFields());
                });
        ;
    }

    private boolean checkField(ValidationResult validationResult, Field field) {
        field.setAccessible(true);
        try {
            return !passRule(field, validationResult.getValidatedObject());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
return false;
    }

    private void addMessage(Field field, Map<String, List<String>> notValidFields) {
        String fieldName = field.getName();
        if(!notValidFields.containsKey(fieldName)) notValidFields.put(fieldName, new ArrayList<>());
        notValidFields.get(fieldName).add(getMessage(field));
    }

    protected abstract String getMessage(Field field);

    protected abstract boolean passRule(Field field, Object obj) throws IllegalAccessException;

    protected abstract boolean hasAnnotation(Field field);

}
