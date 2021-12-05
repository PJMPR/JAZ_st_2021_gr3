package org.example.validators;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    public <TClass> ValidationResult validate(TClass object) {

        final var notValidFields = Arrays.stream(object.getClass().getDeclaredFields())
                .map(field -> new AnnotatedField(field, object))
                .collect(Collectors.toMap(
                        AnnotatedField::getName,
                        field -> AnnotationValidator.combinedAnnotationValidator.getErrors(List.of(field), object)
                ));

        notValidFields.values().removeIf(List::isEmpty);

        return new ValidationResult(object, notValidFields.isEmpty(), notValidFields);
    }
}
