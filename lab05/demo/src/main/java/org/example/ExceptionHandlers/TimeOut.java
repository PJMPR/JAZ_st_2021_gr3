package org.example.ExceptionHandlers;

import org.example.Supplier;

import java.util.concurrent.TimeoutException;

public class TimeOut implements ErrorHandler {

    @Override
    public String getMessage() {
        return "Request Timeout";
    }

    @Override
    public Boolean canHandle(Exception e) {
        return e instanceof TimeoutException;
    }

    @Override
    public void whatNow(Supplier method) {
        actions.canRepeat(method, 3);
    }
}
