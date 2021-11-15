package org.example.ExceptionHandlers;

import java.util.concurrent.TimeoutException;

public class TimeOut implements ErrorHandler {

    @Override
    public String getMessage() {
        return "Timeout bro...";
    }

    @Override
    public Boolean canHandle(Exception e) {
        return e instanceof TimeoutException;
    }

    @Override
    public void whatNow(Object objOfMethod, String method) {
        actionsInvokeByHandlers.reDo(objOfMethod, method);
    }
}
