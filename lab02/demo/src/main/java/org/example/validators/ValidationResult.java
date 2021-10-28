package org.example.validators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationResult{

    private Object validatedObject;
    private boolean isValid;
    private Map<String, List<String>> notValidFields = new HashMap<String, List<String>>();


    public void setValidatedObject(Object validatedObject) {
        this.validatedObject = validatedObject;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public boolean isValid() {
        return isValid;
    }

    public Map<String, List<String>> getNotValidFields() {
        return notValidFields;
    }

    public Object getValidatedObject() {
        return validatedObject;
    }

}