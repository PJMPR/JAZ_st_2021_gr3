package org.example.validators;

import java.lang.reflect.Field;
import java.util.ArrayList;
import org.example.annotations.Regex;
import org.example.annotations.Range;
import org.example.annotations.NotNull;

public class Validator {

    public <TClass> ValidationResult validate(TClass object) throws IllegalArgumentException, IllegalAccessException{
        ValidationResult validationResult = new ValidationResult();
        validationResult.setValidatedObject(object);
        validationResult.setValid(true);
        for (Field field : object.getClass().getDeclaredFields()){
            if(field.isAnnotationPresent(NotNull.class)){
                String string = (String) field.get(object);
                if(string == null){
                    showValidationResult(validationResult, field);
                }
            }
            if(field.isAnnotationPresent(Range.class)){
                int numer = (int) field.get(object);
                Range temp = field.getAnnotation(Range.class);
                if(numer < temp.min() || numer > temp.max()){
                    showValidationResult(validationResult, field);
                }
            }
            if(field.isAnnotationPresent(Regex.class)){
                String string = (String) field.get(object);
                Regex temp = field.getAnnotation(Regex.class);
                if(!string.matches(temp.pattern())){
                    showValidationResult(validationResult, field);
                }
            }
        }
        return validationResult;
    }
    public void showValidationResult(ValidationResult validationResult, Field field){
        validationResult.setValid(false);
        validationResult.getNotValidFields().put(field.getName(),new ArrayList<>());
    }
    
}