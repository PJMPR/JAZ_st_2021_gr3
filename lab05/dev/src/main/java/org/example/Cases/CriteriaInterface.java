package org.example.Cases;

import org.example.Provider;

public interface CriteriaInterface {
    String info();
    boolean canHandle(Exception e);
    boolean handle(Exception e, Provider method);
    void log();
}