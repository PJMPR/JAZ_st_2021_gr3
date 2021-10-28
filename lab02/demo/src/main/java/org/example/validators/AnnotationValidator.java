package org.example.validators;

import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

public class AnnotationValidator {
    public void isNotValidRangeAnnotation(Annotation annotation, Field field, Object object, List<String >errors){
        if (isRangeAnnotation(annotation) && !doFieldMeetsRangeAnnotationRequirements(field, object))
          errors.add(getRangeAnnotationMessage(field));
    }
    public void isNotValidNotNullAnnotation(Annotation annotation,Field field,Object object,List<String >errors){
        if (isNotNullAnnotation(annotation) && doFieldMeetsNotNullAnnotationRequirements(field,object))
            errors.add(getNotNullAnnotationMessage(field));
    }
    public void isNotValidRegexAnnotation(Annotation annotation,Field field,Object object,List<String >errors){
        if (isRegexAnnotation(annotation)&&!doFieldMeetsRegexAnnotationRequirements(field,object))
            errors.add(getRegexAnnotationMessage(field));
    }

    public boolean isRangeAnnotation(Annotation annotation){
        return annotation.annotationType().equals(Range.class);
    }
    public boolean isNotNullAnnotation(Annotation annotation){
        return annotation.annotationType().equals(NotNull.class);
    }
    public boolean isRegexAnnotation(Annotation annotation){
        return annotation.annotationType().equals(Regex.class);
    }
    public boolean doFieldMeetsRangeAnnotationRequirements(Field field,Object object)  {
            int max = field.getDeclaredAnnotation(Range.class).max();
            int min = field.getDeclaredAnnotation(Range.class).min();
        int valueOfField = 0;
        try {
            valueOfField = field.getInt(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return valueOfField <= max && valueOfField >= min;
    }
    public boolean doFieldMeetsNotNullAnnotationRequirements(Field field,Object object)  {
        try {
            return field.get(object)==(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean doFieldMeetsRegexAnnotationRequirements(Field field,Object object)  {
        try {
            if (field.get(object)!=null){
                String regex = field.getDeclaredAnnotation(Regex.class).pattern();
                String  valueOfField = field.get(object).toString();
                return valueOfField.matches(regex);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return false;
    }

    public String getRangeAnnotationMessage(Field field){
        return "number is out of range ["+field.getAnnotation(Range.class).min()+","+field.getAnnotation(Range.class).max()+"]";
    }

    public String getRegexAnnotationMessage(Field field){
        return field.getAnnotation(Regex.class).message();
    }

    public String getNotNullAnnotationMessage(Field field){
        return field.getAnnotation(NotNull.class).message();
    }
}
