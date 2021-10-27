package org.example.validators;

import org.example.annotations.Range;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class AnnotatedField {
    private final Field base;
    private final Object value;

    public AnnotatedField(Field base, Object object) {
        Object tmpValue;
        this.base = base;
        base.setAccessible(true);
        try {
            tmpValue = base.get(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            tmpValue = null;
        }
        this.value = tmpValue;
    }

    public boolean isNumber() {
        return Stream.of(int.class, float.class, double.class)
                .anyMatch(type -> this.base.getType().equals(type));
    }

    public boolean isString() {
        return this.base.getType().equals(String.class);
    }

    public String getAsString() {
        return (String) value;
    }

    public Number getAsNumber() {
        return (Number) value;
    }

    public String getName() {
        return base.getName();
    }

    public boolean notMatchesRegex(final String pattern) {
        return !this.getAsString().matches(pattern);
    }

    public boolean isNull() {
       return value == null;
    }

    public boolean isNotWithinAnnotatedRange() {
        final var value = this.getAsNumber();
        final var range = (Range) this.getAnnotation(Range.class);
        return value.doubleValue() > range.max() || value.doubleValue() < range.min();
    }

    public boolean hasAnnotation(Class<?> annotation) {
        return Arrays.stream(this.base.getAnnotations())
                .map(Annotation::annotationType)
                .anyMatch(type -> type.equals(annotation));
    }

    public <T extends Annotation> Annotation getAnnotation(Class<T> clazz) {
        return this.base.getAnnotation(clazz);
    }
}
