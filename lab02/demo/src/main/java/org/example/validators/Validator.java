package org.example.validators;


import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Validator {

    // Checks that object of class is validate correctly
    public <TClass> ValidationResult validate(TClass object) throws IllegalAccessException {

        // Creating validationResult object
        ValidationResult validationResult = new ValidationResult();

        // Setting validate object
        validationResult.setValidatedObject(object);

        // Messages for errors
        List<String> messageBox = new ArrayList<String>();

        // @NotNull
        // For each field search @NotNull
        for (Field field : validationResult.getFields()) {

            // Create validationHelper
            ValidationHelper validationHelper = new ValidationHelper(object, field);

            if(validationHelper.notNullCheck()){
                messageBox.add(validationHelper.returnNotNullMessage());
            }

            if(validationHelper.regexCheck()){
                messageBox.add(validationHelper.returnRegexMessage());
            }

            if(validationHelper.rangeCheck()){
                messageBox.add(validationHelper.returnRangeMessage());
            }
            // Puy all messages into validationResult
            validationResult.putArray(field, messageBox);
        }

        return validationResult;
    }
}
