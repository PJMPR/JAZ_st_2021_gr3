package org.example.Handlers.ErrorExceptions;

import org.example.Handlers.LoggerOperations;
import org.example.Provider;

public class FileNotFoundException extends LoggerOperations {
    public FileNotFoundException() {
        super(FileNotFoundException.class);
    }

    @Override
    public String message() {
        return "File wasn't found";
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
        return exception instanceof java.io.FileNotFoundException;
    }
}