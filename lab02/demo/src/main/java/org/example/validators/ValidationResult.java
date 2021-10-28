package org.example.validators;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidationResult{

    private Object validatedObject;
    private boolean isValid;

    // Creates map that have String as key and List as parameter
    private Map<String, List<String>> notValidFields = new HashMap<String, List<String>>();

    // Getting validated object
    public Object getValidatedObject() {
        return validatedObject;
    }

    // setting valid object
    public void setValidatedObject(Object validatedObject) {
        this.validatedObject = validatedObject;
    }

    // Checking statement of valid
    public boolean isValid() {
        return false;
    }

    // Setting valid option
    public void setValid(boolean valid) {
        isValid = valid;
    }

    // Returns notValidFields
    public Map<String, List<String>> getNotValidFields() {
        return notValidFields;
    }

    // Return class of object
    private Class<?> returnClass(){
        return validatedObject.getClass();
    }

    public void putArray(Field field, List<String> arrayList){
        getNotValidFields().put(field.getName(), arrayList);
    }

    // Return array of Fields
    public Field[] getFields(){
        return returnClass().getDeclaredFields();
    }

}
