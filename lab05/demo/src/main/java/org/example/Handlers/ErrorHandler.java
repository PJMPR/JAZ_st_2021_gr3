package org.example.Handlers;

import org.example.Provider;

public interface ErrorHandler {
    void handle(Provider method, Exception e);

    boolean canHandle(Exception exception);

    String message();
}