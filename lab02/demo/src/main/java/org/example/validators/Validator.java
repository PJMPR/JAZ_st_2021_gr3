package org.example.validators;


import org.example.annotations.NotNull;
import org.example.annotations.Range;
import org.example.annotations.Regex;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Validator {

    public <TClass> ValidationResult validate(TClass object) throws IllegalAccessException  {
        ValidationResult validationResult= new ValidationResult();
        validationResult.setValidatedObject(object);
        validationResult.setValid(true);

        HashMap<String, List<String>> hashMapWhichFieldisInvalid = new HashMap<>();
        validationResult.setNotValidFields(hashMapWhichFieldisInvalid);


        CheckFields checkFields = new CheckFields();

        Field[] fields = object.getClass().getDeclaredFields();


        //Splitting all fields into smaller groups in order to their annotations
        ArrayList<Field> notNullFields =    checkFields.returnOnlyNotNullFields(fields);
        ArrayList<Field> regexFields =      checkFields.returnOnlyregexFields(fields);
        ArrayList<Field> rangeFields =      checkFields.returnOnlyRangeFields(fields);

        //checking each group
        Boolean iSNotNullFieldsOk =      checkFields.checkNotNullFields(notNullFields,validationResult.getValidatedObject());
        Boolean ischeckRegexFieldsOk =   checkFields.checkRegexFields(regexFields,validationResult.getValidatedObject());
        Boolean ischeckRangeFieldsOk =   checkFields.checkRangeFields(rangeFields,validationResult.getValidatedObject());

        // if one of booleans higher are false then validation is false
        if(!iSNotNullFieldsOk || !ischeckRangeFieldsOk || !ischeckRegexFieldsOk){
            validationResult.setValid(false);

            // set hashmap with  ready hashmap form CheckFields Class
            validationResult.setNotValidFields(checkFields.returnHashMapWithInvalidFields());
        }

        return validationResult;
    }

}
