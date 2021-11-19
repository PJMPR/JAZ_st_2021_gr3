package org.example;

import org.apache.log4j.PropertyConfigurator;
import org.example.Exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class SafeInvoker {

     public final List<ErrorInterface> list = new ArrayList<>(List.of(
             new FileNotFound(),
             new Timeout(),
             new IO(),
             new SQL()
     ));

     public void invoke(Invoker method){
         String log4j = "src/logs/log4j.properties";
         PropertyConfigurator.configure(log4j);
         try {
             method.invoke();
         } catch (Exception exception){
             list.stream().filter(list ->
                     list.canHandle(exception))
                     .forEach(list -> {
                         try {
                             list.handle(exception, method);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                     });
         }
     }
}
