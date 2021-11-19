package Strategy;


import Logger.Logger;

import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class ConnectionLostStrategy implements Strategy {
    String name= "TimeoutException";

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void whatToDo(Class objectToInvokeMethodFrom,String name ,Logger logger) {
        final var rehearsalsLeft = new AtomicInteger(4);
        final var executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(() -> {
            if (rehearsalsLeft.decrementAndGet() <= 0) {
                executor.shutdown();
            }
            try {
                Class c = Class.forName(objectToInvokeMethodFrom.getName());
                Object o = c.newInstance();
                Method m = c.getDeclaredMethod(name);
                m.setAccessible(true);
                m.invoke(o);
            } catch (Exception exception) {
                logger.loggerError(getName(), exception);
            }
        }, 50, 50, TimeUnit.MILLISECONDS);

    }

}
