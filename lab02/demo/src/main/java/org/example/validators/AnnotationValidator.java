package org.example.validators;

import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class AnnotationValidator {
    public boolean isRangeAnnotation(Annotation annotation){
        return annotation.annotationType().equals(Range.class);
    }
    public boolean isNotNullAnnotation(Annotation annotation){
        return annotation.annotationType().equals(NotNull.class);
    }
    public boolean isRegexAnnotation(Annotation annotation){
        return annotation.annotationType().equals(Regex.class);
    }
    public boolean doFieldMeetsRangeAnnotationRequirements(Field field,Annotation annotation,Object object) throws IllegalAccessException {
            int max = field.getDeclaredAnnotation(Range.class).max();
            int min = field.getDeclaredAnnotation(Range.class).min();
            int valueOfField = field.getInt(object);
            if (valueOfField>max || valueOfField<min){
                return false;
            }else return true;
    }
    public boolean doFieldMeetsNotNullAnnotationRequirements(Field field,Annotation annotation,Object object) throws IllegalAccessException {
        return field.get(object)==(null);
    }
    public boolean doFieldMeetsRegexAnnotationRequirements(Field field,Annotation annotation,Object object) throws IllegalAccessException {
        if (field.get(object)!=null){
            String regex = field.getDeclaredAnnotation(Regex.class).pattern();
            String  valueOfField = field.get(object).toString();

            return valueOfField.matches(regex);
        }
        return false;
    }
}
