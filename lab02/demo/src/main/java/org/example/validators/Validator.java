package org.example.validators;

import java.util.*;

public class Validator {

    private final AnnotationValidator annotationValidator = new AnnotationValidator();

    public <TClass> ValidationResult validate(TClass object) {
        ValidationResult validationResult = new ValidationResult();
        validationResult.setValidatedObject(object);
        Arrays.stream(object.getClass().getDeclaredFields()).toList().forEach(field ->{
            field.setAccessible(true);
            List<String> errors = new ArrayList<>();
            Arrays.stream(field.getAnnotations()).toList().forEach(annotation -> {
                annotationValidator.isNotValidRangeAnnotation(annotation,field,object,errors);
                annotationValidator.isNotValidNotNullAnnotation(annotation,field,object,errors);
                annotationValidator.isNotValidRegexAnnotation(annotation,field,object,errors);
            });
            validationResult.getNotValidFields().put(field.getName(), errors);
        });
        validationResult.getNotValidFields().values().removeIf(List::isEmpty);
        validationResult.setValid(validationResult.getNotValidFields().isEmpty());
        return validationResult;
    }
}