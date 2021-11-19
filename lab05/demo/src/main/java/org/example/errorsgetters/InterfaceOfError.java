package org.example.errorsgetters;

public interface InterfaceOfError {

    String getMessage();

    boolean errorIsTrue(Exception e);

    void handler(Exception e, ExceptionGetter getException);
}
