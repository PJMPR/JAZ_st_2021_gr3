package org.example.validators;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.example.annotations.*;
public class Validator {

    public <TClass> ValidationResult validate(TClass object){
        ValidationResult validationResult = new ValidationResult();
        validationResult.setValidatedObject(object);

        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            List<String> errorList = new ArrayList<>();

            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    if (field.get(object) == null) {
                        errorList.add(field.getAnnotation(NotNull.class).message());
                        validationResult.setValid(false);
                        //System.out.println(field.getAnnotation(NotNull.class).message());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if(field.isAnnotationPresent(Regex.class)) {
                try {
                    if (!field.get(object).toString().matches(field.getAnnotation(Regex.class).pattern())) {
                        errorList.add(field.getAnnotation(Regex.class).message());
                        validationResult.setValid(false);
                        //System.out.println(field.getAnnotation(Regex.class).message());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

            if (field.isAnnotationPresent(Range.class)) {
                int min = field.getAnnotation(Range.class).min();
                int max = field.getAnnotation(Range.class).max();
                int i = 0;
                try {
                    i = (int) field.get(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                if ((i < min || i > max)) {
                    errorList.add(field.getAnnotation(Range.class).message());
                    validationResult.setValid(false);
                    //System.out.println(min + "\n" + max + "\n" + field.getAnnotation(Range.class).message());
                }
            }

            if (errorList.size() != 0) {
                validationResult.getNotValidFields().put(field.getName(), errorList);
            }
        }
        return validationResult;
    }
}
