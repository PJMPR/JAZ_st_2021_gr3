package org.example.Exceptions;

import org.example.Invoker;

public interface ErrorInterface {
    String getMessage();
    boolean canHandle(Exception exception);
    boolean handle(Exception exception, Invoker method) throws InterruptedException;
    void log();
}
