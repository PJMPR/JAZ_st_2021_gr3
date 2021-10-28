package org.example.validators;


import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.util.*;

public class Validator {
    public <TClass> ValidationResult validate(TClass object) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setValidatedObject(object);
        validationResult.setValid(true);
        List<String> list = new ArrayList();
        for (Field field : object.getClass().getDeclaredFields()){
            field.setAccessible(true);
            if(field.isAnnotationPresent(NotNull.class)){
                try {
                    String isNull = (String) field.get(object);

                    if(isNull==null){
                        validationResult.setValid(false);
                        list.add(field.getAnnotation(NotNull.class).message());
                        validationResult.getNotValidFields().put(field.getName(),list);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if(field.isAnnotationPresent(Regex.class)){
                try {
                    String reg = (String) field.get(object);
                    if(!reg.matches(field.getDeclaredAnnotation(Regex.class).pattern())){
                        validationResult.setValid(false);
                        list.add(field.getAnnotation(Regex.class).message());
                        validationResult.getNotValidFields().put(field.getName(),list);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if(field.isAnnotationPresent(Range.class)){
                try {
                    Integer  rng = (Integer) field.get(object);
                    if(field.getDeclaredAnnotation(Range.class).min() < rng || field.getDeclaredAnnotation(Range.class).max() > rng){
                        validationResult.setValid(false);
                        list.add(field.getAnnotation(Range.class).message());
                        validationResult.getNotValidFields().put(field.getName(),list);
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return validationResult;
    }
}

