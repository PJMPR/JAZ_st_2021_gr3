package org.example.errorsgetters;

import java.io.FileNotFoundException;
import java.sql.SQLTimeoutException;

public class TimeError implements InterfaceOfError{

    @Override
    public String getMessage(){
        return "Time out";
    }

    @Override
    public boolean errorIsTrue(Exception e){
        return e instanceof SQLTimeoutException;
    }

    @Override
    public void handler(Exception e, ExceptionGetter getException){
        if(errorIsTrue(e)){
            System.out.println(getMessage());
        }
    }
}
