package org.example.validators;


import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.reflect.Field;
import java.util.*;

public class Validator {

    public <TClass> ValidationResult validate(TClass object) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setValidatedObject(object);
        ArrayList<String> one = new ArrayList<>();
        Field[] fields = object.getClass().getDeclaredFields();
        validationResult.setValid(true);
        for (Field field : fields) {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class)) {
                    String isItNull = null;
                    try {
                        isItNull = (String) field.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if (isItNull == null) {
                        validationResult.setValid(false);
                        one.add(field.getAnnotation(NotNull.class).message());
                        validationResult.getNotValidFields().put(field.getName(),one);

                    }
                }
                if (field.isAnnotationPresent(Regex.class)) {
                    String toRegex = null;
                    try {
                        toRegex = (String) field.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if (!toRegex.matches(field.getAnnotation(Regex.class).pattern())) {
                        one.add(field.getAnnotation(Regex.class).message());
                        validationResult.getNotValidFields().put(field.getName(),one);
                        validationResult.setValid(false);

                    }
                }
                if (field.isAnnotationPresent(Range.class)){
                    Integer checkRange = null;
                    try {
                        checkRange = (Integer) field.get(object);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                    if (checkRange> field.getAnnotation(Range.class).max()  || checkRange < field.getAnnotation(Range.class).min()) {
                        validationResult.setValid(false);
                        one.add(field.getAnnotation(Range.class).message()+" ["+field.getAnnotation(Range.class).min()+","
                                +field.getAnnotation(Range.class).max()+"]");
                        validationResult.getNotValidFields().put(field.getName(), one);
                    }
                }

        }
        return validationResult;
    }
}

