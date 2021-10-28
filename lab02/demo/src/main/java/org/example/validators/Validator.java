package org.example.validators;


import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Validator {
    public <TClass> ValidationResult validate(TClass object) {
        Map<String, List<String>> notValidFields = new HashMap<>();
        boolean isValid = true;
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            List<String> errorMessages = new ArrayList<>();
            boolean isFieldValid = true;
            if (field.isAnnotationPresent(NotNull.class)) {
                String errorMessage = field.getAnnotation(NotNull.class).message();
                if (!NotNullValidator.isValid(object, field)) {
                    isFieldValid = false;
                    isValid = false;
                    errorMessages.add(errorMessage);
                }
            }
            if (field.isAnnotationPresent(Range.class)) {
                field.getAnnotation(Range.class).min();
                field.getAnnotation(Range.class).max();
                if (!RangeValidator.isValid(object, field)) {
                    isFieldValid = false;
                    isValid = false;
                    String errorMessage = "number is out of range [" + field.getAnnotation(Range.class).min() + "," + field.getAnnotation(Range.class).max() + "]";
                    errorMessages.add(errorMessage);
                }
            }
            if (field.isAnnotationPresent(Regex.class)) {
                String errorMessage = field.getAnnotation(Regex.class).message();
                if (!RegexValidator.isValid(object, field)) {
                    isFieldValid = false;
                    isValid = false;
                    errorMessages.add(errorMessage);
                }
            }
            if (!isFieldValid) {
                notValidFields.put(field.getName(), errorMessages);
            }
        }
        return new ValidationResult(object, isValid, notValidFields);
    }
}

