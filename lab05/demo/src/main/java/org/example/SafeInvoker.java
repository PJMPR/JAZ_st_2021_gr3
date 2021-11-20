package org.example;

import org.example.Handlers.LoggerOperations;
import org.example.Handlers.ErrorExceptions.*;

import java.util.List;

public class SafeInvoker {
    private final List<LoggerOperations> errorHandlers = List.of(
            new FileNotFoundException(),
            new IOException(),
            new SQLException(),
            new TimeoutException()
    );

    public LoggerOperations findErrorHandler(Exception exception){
        return errorHandlers.stream()
                .filter(errorHandler -> errorHandler.canHandle(exception))
                .findAny().orElse(new DefaultException());
    }

    public void invoke(Provider provider){
        try{
            provider.execute();
        }catch (Exception exception){
            findErrorHandler(exception).handle(provider, exception);
        }
    }
}