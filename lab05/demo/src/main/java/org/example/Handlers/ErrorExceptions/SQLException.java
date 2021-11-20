package org.example.Handlers.ErrorExceptions;

import org.example.Handlers.LoggerOperations;
import org.example.Provider;

public class SQLException extends LoggerOperations {
    public SQLException() {
        super(SQLException.class);
    }

    @Override
    public String message() {
        return "No connection to database";
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
        return exception instanceof java.sql.SQLException;
    }
}