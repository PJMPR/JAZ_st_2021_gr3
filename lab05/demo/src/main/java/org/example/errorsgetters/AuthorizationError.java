package org.example.errorsgetters;

import java.io.FileNotFoundException;
import java.sql.SQLInvalidAuthorizationSpecException;

public class AuthorizationError implements InterfaceOfError {

    @Override
    public String getMessage(){
        return "Lack of Authorization";
    }

    @Override
    public boolean errorIsTrue(Exception e){
        return e instanceof SQLInvalidAuthorizationSpecException;
    }

    @Override
    public void handler(Exception e, ExceptionGetter getException){
        if(errorIsTrue(e)){
            System.out.println(getMessage());
        }
    }
}
