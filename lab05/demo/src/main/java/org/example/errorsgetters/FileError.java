package org.example.errorsgetters;

import java.io.FileNotFoundException;

public class FileError implements InterfaceOfError{

    @Override
    public String getMessage(){
        return "File do not exist";
    }

    @Override
    public boolean errorIsTrue(Exception e){
        return e instanceof FileNotFoundException;
    }

    @Override
    public void handler(Exception e, ExceptionGetter getException){
        if(errorIsTrue(e)){
            System.out.println(getMessage());
        }
    }
}
