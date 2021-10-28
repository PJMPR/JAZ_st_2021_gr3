package org.example.validators;


import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;

public class Validator {

    public <TClass> ValidationResult validate(TClass object) {
        AnnotationValidator annotationValidator = new AnnotationValidator();
        ValidationResult validationResult = new ValidationResult();
        validationResult.setValid(true);

        var notValidatedFields = object.getClass().getDeclaredFields();
        for (Field field: notValidatedFields) {
            field.setAccessible(true);

            Arrays.stream(field.getAnnotations()).toList().forEach(annotation -> {
                List<String> errors = new ArrayList<>();
                if (annotationValidator.isRangeAnnotation(annotation)) {
                    try {
                        if (!annotationValidator.doFieldMeetsRangeAnnotationRequirements(field,annotation,object)) {
                            validationResult.setValid(false);
                            validationResult.setValidatedObject(object);
                            errors.add("number is out of range ["+field.getAnnotation(Range.class).min()+","+field.getAnnotation(Range.class).max()+"]");
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                else if (annotationValidator.isNotNullAnnotation(annotation)) {
                    try {
                        if (annotationValidator.doFieldMeetsNotNullAnnotationRequirements(field,annotation,object)) {
                            System.out.println(field.getName());
                            validationResult.setValid(false);
                            validationResult.setValidatedObject(object);
                            errors.add(field.getAnnotation(NotNull.class).message());
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                else if (annotationValidator.isRegexAnnotation(annotation)) {

                    try {
                        if (!annotationValidator.doFieldMeetsRegexAnnotationRequirements(field,annotation,object)) {
                            validationResult.setValid(false);
                            validationResult.setValidatedObject(object);
                            errors.add(field.getAnnotation(Regex.class).message());
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                if (errors.size()!=0)
                    validationResult.getNotValidFields().put(field.getName(),errors);
            });
        }
        return validationResult;
    }
}