package org.example.validators;

import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


import org.example.validators.rules.*;

import java.util.List;

public class Validator {


    public <TClass> ValidationResult validate(TClass object) throws IllegalAccessException {
        ValidationResult result = new ValidationResult();
        result.setValidatedObject(object);
        result.setValid(true);
        List<String> list = new ArrayList<>();

        for (Field field: object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)){
                try {
                    if(field.get(object) == null){
                        list.add(field.getAnnotation(NotNull.class).message());
                    }

                }catch (IllegalAccessException exception){
                    exception.printStackTrace();
                }

                }
            if(field.isAnnotationPresent(Regex.class)){
                System.out.println(field.getAnnotation(Regex.class).pattern());
                try{
                    if(!field.get(object).toString().matches(field.getAnnotation(Regex.class).pattern())){
                        list.add(field.getAnnotation(Regex.class).message());
                    }
                }
                catch (IllegalAccessException exception){
                    exception.printStackTrace();
                }

            }
            if(field.isAnnotationPresent(Range.class)){
                try {
                int value = (Integer) field.get(object);
                    if (field.getAnnotation(Range.class).min() > value || field.getAnnotation(Range.class).max() < value){
                        list.add(field.getAnnotation(Range.class).message());
                    }
                } catch (IllegalAccessException exception){
                    exception.printStackTrace();
                }
            }
            if(!list.isEmpty()){
                result.getNotValidFields().put(field.getName(), new ArrayList<>(list));
                list.clear();
            }
        }


        if(result.getNotValidFields().size() != 0){
            result.setValid(false);
        }




        return result;

    }
}
