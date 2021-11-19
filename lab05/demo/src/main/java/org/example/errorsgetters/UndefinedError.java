package org.example.errorsgetters;

import java.sql.SQLTimeoutException;

public class UndefinedError implements InterfaceOfError{

    @Override
    public String getMessage(){
        return "Undefined";
    }

    @Override
    public boolean errorIsTrue(Exception e){
        return true;
    }

    @Override
    public void handler(Exception e, ExceptionGetter getException){
        if(errorIsTrue(e)){
            System.out.println(getMessage());
        }
    }
}
