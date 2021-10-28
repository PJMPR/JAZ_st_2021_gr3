package org.example.validators;

import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.util.List;
import java.util.stream.Stream;

public interface AnnotationValidator {
    Stream<String> getErrors(List<AnnotatedField> fields, Object object);

    AnnotationValidator notNullAnnotation = (fields, object) -> fields.stream()
            .filter(field -> field.hasAnnotation(NotNull.class))
            .filter(AnnotatedField::isNull)
            .map(field -> field.getAnnotation(NotNull.class))
            .map(NotNull::message);

    AnnotationValidator regexAnnotation = (fields, object) -> fields.stream()
            .filter(field -> field.hasAnnotation(Regex.class))
            .filter(AnnotatedField::isString)
            .filter(field -> field.notMatchesRegex(field.getAnnotation(Regex.class).pattern()))
            .map(field -> field.getAnnotation(Regex.class))
            .map(Regex::message);

    AnnotationValidator rangeAnnotation = (fields, object) -> fields.stream()
            .filter(field -> field.hasAnnotation(Range.class))
            .filter(AnnotatedField::isNumber)
            .filter(AnnotatedField::isNotWithinAnnotatedRange)
            .map(field -> field.getAnnotation(Range.class))
            .map(range -> "number is out of range [%d,%d]".formatted(range.min(), range.max()));

    AnnotationValidator combinedAnnotationValidator = (fields, object) -> Stream.of(
            AnnotationValidator.notNullAnnotation.getErrors(fields, object),
            AnnotationValidator.regexAnnotation.getErrors(fields, object),
            AnnotationValidator.rangeAnnotation.getErrors(fields, object)
    ).flatMap(v -> v);
}