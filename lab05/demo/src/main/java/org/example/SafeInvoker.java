package org.example;

import org.example.ExceptionHandlers.ErrorHandler;
import org.example.ExceptionHandlers.FileNotFound;
import org.example.ExceptionHandlers.TimeOut;

import java.util.List;

public class SafeInvoker {

    List<ErrorHandler> errorHandlers = List.of(
            new FileNotFound(),
            new TimeOut()
    );


    public void invoke(Supplier method) throws Exception {
        try{
            method.get();
        }catch (Exception err){
            for (ErrorHandler handle: errorHandlers) {
                handle.handle(method, err);
            }
        }
    }
}
