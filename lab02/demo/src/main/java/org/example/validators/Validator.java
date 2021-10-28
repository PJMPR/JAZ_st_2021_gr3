package org.example.validators;

import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;
import java.lang.reflect.Field;

public class Validator {
    public <TClass> ValidationResult validate(TClass object) throws IllegalAccessException {

        AnnotationValidator validator = new AnnotationValidator();
        validator.setValidatedObject(object);

        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field: fields) {

            field.setAccessible(true);
            validator.setActualField(field);

            if(field.isAnnotationPresent(NotNull.class)){
                validator.validateNotNull();
            }

            if(field.isAnnotationPresent(Regex.class)){
                validator.validateRegex();
            }

            if(field.isAnnotationPresent(Range.class)){
                validator.validateRange();
            }
        }

        return validator;
    }
}
