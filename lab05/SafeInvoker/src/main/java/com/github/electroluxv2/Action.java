package com.github.electroluxv2;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface Action {
    void invoke(final UnsafeMethod calledMethod, AtomicBoolean actionLock, Logger logger);

    Action NONE = (calledMethod, actionLock, logger) -> actionLock.set(false);
    Action repeatThreshold = (calledMethod, actionLock, logger) -> {
        final var rehearsalsLeft = new AtomicInteger(9);
        final var executor = Executors.newSingleThreadScheduledExecutor();

        executor.scheduleAtFixedRate(() -> {
            if (rehearsalsLeft.decrementAndGet() <= 0) {
                executor.shutdown();
                actionLock.set(false);
            }

            try {
                logger.log(Level.INFO, "Repeating same method, rehearsals left: %d".formatted(rehearsalsLeft.get()));
                calledMethod.invoke();
            } catch (final Exception exception) {
                logger.log(Level.WARNING, "An %s error occurred during repeated action".formatted(exception.getClass().getName()), exception);
            }
        }, 50, 50, TimeUnit.MILLISECONDS);
    };
}
