package org.example;

import org.apache.log4j.PropertyConfigurator;
import org.example.Handlers.*;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeInvoker {
    List<Handler> errorHandlersList = new ArrayList<>(List.of(
            new FileNotFoundHandler(),
            new TimeoutExceptionHandler(),
            new SQLExceptionHandler()
    ));
    public void invoke(Provider method){
        String log4jPath= "src/main/java/org/example/Loger/log4j.properties";
        PropertyConfigurator.configure(log4jPath);

        try {
            method.execute();
        } catch (Exception e){
            AtomicBoolean wasHandled = new AtomicBoolean(false);
            errorHandlersList.stream()
                    .filter(errorHandler -> errorHandler.canHandle(e))
                    .forEach(handler -> {
                        handler.execute(e,method);
                        wasHandled.set(true);
                    });
            if (!wasHandled.get()) DefaultErrorHandler.execute(e,method);

        }


    }

}
