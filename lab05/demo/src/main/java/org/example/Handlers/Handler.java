package org.example.Handlers;

import org.example.Provider;

public interface Handler {
    String info();
    boolean canHandle(Throwable e);
    boolean execute(Exception e, Provider method);
    void log();
}
