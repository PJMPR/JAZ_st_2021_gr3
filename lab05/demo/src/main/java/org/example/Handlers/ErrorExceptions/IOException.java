package org.example.Handlers.ErrorExceptions;

import org.example.Handlers.LoggerOperations;
import org.example.Provider;

public class IOException extends LoggerOperations {
    public IOException() {
        super(IOException.class);
    }

    @Override
    public String message() {
        return "Unable to get to the resource";
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
        return exception instanceof java.io.IOException;
    }
}