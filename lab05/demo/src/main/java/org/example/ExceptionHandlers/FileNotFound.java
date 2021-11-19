package org.example.ExceptionHandlers;

import org.example.Supplier;

import java.io.FileNotFoundException;

public class FileNotFound implements ErrorHandler {

    @Override
    public String getMessage() {
        return "File do not exist, sorry...";
    }

    @Override
    public Boolean canHandle(Exception e) {
        return e instanceof FileNotFoundException;
    }

    @Override
    public void whatNow(Supplier method) {
        if(!actions.canRepeat(method, 1)){
            functionToDo();
        }
    }

    public void functionToDo(){
        System.out.println("Feature to do smth to program here");
    }
}
