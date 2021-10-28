package org.example.validators;

import java.lang.reflect.Field;

class NotNullValidator {
    public static <TClass> boolean isValid(TClass object, Field field) {
        boolean isValid = false;
        field.setAccessible(true);
        try {
            isValid = (field.get(object) != null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return isValid;
    }
}
