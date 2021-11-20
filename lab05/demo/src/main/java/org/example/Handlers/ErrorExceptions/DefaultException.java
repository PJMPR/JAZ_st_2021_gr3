package org.example.Handlers.ErrorExceptions;

import org.example.Handlers.LoggerOperations;
import org.example.Provider;

public class DefaultException extends LoggerOperations {
    public DefaultException() {
        super(DefaultException.class);
    }

    @Override
    public String message() {
        return "An unspecified error occured :(";
    }

    @Override
    public void handle(Provider method, Exception exception){
        response(exception);
    };

    @Override
    public boolean canHandle(Exception exception) {
        return exception != null;
    }
}