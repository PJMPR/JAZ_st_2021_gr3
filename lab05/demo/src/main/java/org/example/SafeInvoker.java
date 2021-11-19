package org.example;

import org.example.errorsgetters.*;
import org.xml.sax.ErrorHandler;

import java.util.List;

public class SafeInvoker {

    private final List<InterfaceOfError> errors = List.of(
            new AuthorizationError(),
            new FileError(),
            new TimeError()
            );

    public void invoke(ExceptionGetter exceptionGetter){
        try{
            exceptionGetter.throwException();
        } catch (Exception e){
            findError(e).handler(e, exceptionGetter);
        }
    }

    public InterfaceOfError findError(Exception e){
        return errors.stream().filter(error -> error.errorIsTrue(e))
                .findAny().orElse(new UndefinedError());
    }
}
