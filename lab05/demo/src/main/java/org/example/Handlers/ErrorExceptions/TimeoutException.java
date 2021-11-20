package org.example.Handlers.ErrorExceptions;

import org.example.Handlers.LoggerOperations;
import org.example.Provider;

public class TimeoutException extends LoggerOperations {
    public TimeoutException() {
        super(TimeoutException.class);
    }

    @Override
    public String message() {
        return "Connection timed out";
    }

    @Override
    public void handle(Provider method, Exception exception) {
        if(canHandle(exception)) {
            if (retry(method, 4, 1000)) {
                response(exception);
            }
        }
    }

    @Override
    public boolean canHandle(Exception exception) {
        return exception instanceof java.util.concurrent.TimeoutException;
    }
}