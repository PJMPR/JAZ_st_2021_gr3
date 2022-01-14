package org.example.validators;


import org.example.validators.rules.*;

import java.util.List;

public class Validator {

    List<ICheckValidationRule> rules =List.of(
            new NotNullValidationRule(),
            new RegexValidationRule(),
            new RangeValidationRule()
    );

    public <TClass> ValidationResult validate(TClass object){

        ValidationResult result = new ValidationResult();
        result.setValidatedObject(object);
        result.setValid(true);
        rules.stream().forEach(rule->rule.ValidateRule(result));
        return result;
    }
}
