package org.example.ExceptionHandlers;

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
    public void whatNow(Object objOfMethod, String method) {
        actionsInvokeByHandlers.reDo(objOfMethod, method);
        }
    }
