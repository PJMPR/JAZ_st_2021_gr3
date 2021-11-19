package org.example;

import extands.*;
import org.apache.log4j.PropertyConfigurator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class SafeInvoker {
    List<ExtandHandler> extandHandlers = new ArrayList<>(List.of(
            new SQLExceptionHandler(),
            new TimeOutHandler(),
            new FileNotFoundHandler(),
            new ClassNotFoundHandler(),
            new DefaultExtendInterfaceHandler()
    ));

    public void invoke(Supplier method){
        String log4jPath = "src/main/java/log4j.properties";
        PropertyConfigurator.configure(log4jPath);
        try {
            method.execute();
        } catch (Exception exception) {
            AtomicBoolean wasHandled = new AtomicBoolean(false);
            extandHandlers.stream()
                    .filter(extandHandler -> extandHandler.canHandle(exception))
                    .forEach(extandHandler -> {
                        try {
                            extandHandler.handle(exception,method);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        wasHandled.set(true);
                    });
            if(!wasHandled.get()){
                DefaultExtendInterfaceHandler defaultExtendInterfaceHandler = new DefaultExtendInterfaceHandler();
                defaultExtendInterfaceHandler.handle(exception, method);
            }
        }
    }
}
