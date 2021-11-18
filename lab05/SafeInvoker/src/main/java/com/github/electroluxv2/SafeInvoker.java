package com.github.electroluxv2;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.*;

interface UnsafeMethod {
    void invoke() throws Exception;
}

public enum SafeInvoker {
    INSTANCE;

    static private final Map<Class<? extends Exception>, Action> actionRegistry = new HashMap<>();
    static private final Logger logger = Logger.getLogger(SafeInvoker.class.getName());

    static {
        try {
            final var fileHandler = new FileHandler("./%s.log".formatted(SafeInvoker.class.getSimpleName()));
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setActionForException(Class<? extends Exception> exception, Action action) {
        actionRegistry.put(exception, action);
    }

    public void invoke(UnsafeMethod unsafeMethod) {
        AtomicBoolean actionLock = new AtomicBoolean(true);

        try {
            unsafeMethod.invoke();
        } catch (Exception exception) {
            final var action = actionRegistry.getOrDefault(exception.getClass(), Action.NONE);
            logger.log(Level.INFO, "An %s occurred, invoking action.".formatted(exception.getClass().getName()), exception);
            action.invoke(unsafeMethod, actionLock, logger);
        }

        while (actionLock.get()) {
            System.out.println("Waiting for action to complete");
        }
    }
}
