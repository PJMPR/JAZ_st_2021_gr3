package org.example;

import org.apache.log4j.PropertyConfigurator;
import org.example.Cases.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeInvoker {
    List<CriteriaInterface> handlersList = new ArrayList<>(List.of(
            new FileNotFoundCriteria(),
            new TimeOutCriteria(),
            new ClassNotFoundCriteria()
    ));

    public void invoke(Provider action){
        String log4jPath = "src/main/java/org/example/Loger/log4j.properties";
        PropertyConfigurator.configure(log4jPath);
        DefaultErrorCriteria defaultErrorHandler = new DefaultErrorCriteria();
        try {
            action.execute();
        } catch (Exception e){

            AtomicBoolean wasHandled = new AtomicBoolean(false);

            handlersList.stream()
                    .filter(errorHandler -> errorHandler.canHandle(e))
                    .forEach(handler -> {
                        handler.handle(e,action);
                        wasHandled.set(true);
                    });
            if (!wasHandled.get()) defaultErrorHandler.handle(e,action);
        }

    }
}