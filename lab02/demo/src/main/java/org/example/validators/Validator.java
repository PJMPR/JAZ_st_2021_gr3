package org.example.validators;

import org.example.annotations.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {
    public <TClass> ValidationResult validate(TClass object){
        ValidationResult validationResult = new ValidationResult();
        validationResult.setValidatedObject(object);
        validationResult.setValid(true);

        List<String> exceptions = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            if (field.isAnnotationPresent(Range.class)){
                try{
                    Integer fieldObject = (Integer) field.get(object);

                    if (field.getDeclaredAnnotation(Range.class).min() >= fieldObject ||
                        field.getDeclaredAnnotation(Range.class).max() <= fieldObject) {
                        exceptions.add(field.getAnnotation(Range.class).message());
                        validationResult.setValid(false);
                    }
                }catch (IllegalAccessException e){e.printStackTrace();}
            }
            if (field.isAnnotationPresent(Regex.class)){
                try {
                    if(!field.get(object).toString().matches(field.getDeclaredAnnotation(Regex.class).pattern())){
                        exceptions.add(field.getAnnotation(Regex.class).message());
                        validationResult.setValid(false);
                    }
                }catch(IllegalAccessException e){e.printStackTrace();}
            }
            if (field.isAnnotationPresent(NotNull.class)){
                try{
                    if (field.get(object) == null){
                        exceptions.add(field.getAnnotation(NotNull.class).messageNull());
                        exceptions.add(field.getAnnotation(NotNull.class).messageEmpty());
                        validationResult.setValid(false);
                    }
                }catch(IllegalAccessException e){e.printStackTrace();}
            }
            if (!exceptions.isEmpty()){
                validationResult.getNotValidFields().put(field.getName(),new ArrayList<>(exceptions));
                exceptions.clear();
            }
        }
        return validationResult;
    }
}
