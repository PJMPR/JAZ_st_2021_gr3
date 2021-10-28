package org.example.validators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationResult{

    private Object validatedObject;
    private final Map<String, List<String>> notValidFields = new HashMap<>();
    private boolean isValid;

    public Object getValidatedObject() {
        return validatedObject;
    }

    public void setValidatedObject(Object validatedObject) {
        this.validatedObject = validatedObject;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public Map<String, List<String>> getNotValidFields() {
        return notValidFields;
    }

}
