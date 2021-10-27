package org.example.validators;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Validator {

    public <TClass> ValidationResult validate(TClass object) {

        final var notValidFields = Arrays.stream(object.getClass().getDeclaredFields())
                .map(field -> new AnnotatedField(field, object))
                .collect(Collectors.toMap(
                        AnnotatedField::getName,
                        field -> Stream.of(
                                AnnotationValidator.notNullAnnotation.getErrors(Stream.of(field), object),
                                AnnotationValidator.regexAnnotation.getErrors(Stream.of(field), object),
                                AnnotationValidator.rangeAnnotation.getErrors(Stream.of(field), object)
                        ).flatMap(i -> i).toList()
                ));

        notValidFields.values().removeIf(List::isEmpty);

        return new ValidationResult(object, notValidFields.isEmpty(), notValidFields);
    }
}
