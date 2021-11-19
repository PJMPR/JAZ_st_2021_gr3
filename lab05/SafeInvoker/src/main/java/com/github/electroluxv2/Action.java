package com.github.electroluxv2;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public interface Action {
    void invoke(final UnsafeMethod calledMethod, Exception cause, AtomicBoolean actionLock, Logger logger);

    Action NONE = (calledMethod, cause, actionLock, logger) -> actionLock.set(false);
    Action repeatThreshold = (calledMethod, cause, actionLock, logger) -> {
        final var rehearsalsLeft = new AtomicInteger(9);
        final var executor = Executors.newSingleThreadScheduledExecutor();

        executor.scheduleAtFixedRate(() -> {
            if (rehearsalsLeft.decrementAndGet() <= 0) {
                executor.shutdown();
                actionLock.set(false);
            }

            try {
                logger.log(Level.INFO, "Repeating same method because an %s occurred, rehearsals left: %d".formatted(cause.getClass().getSimpleName() ,rehearsalsLeft.get()));
                calledMethod.invoke();
            } catch (final Exception exception) {
                logger.log(Level.WARNING, "An %s error occurred during repeated action".formatted(exception.getClass().getName()), exception);
            }
        }, 50, 50, TimeUnit.MILLISECONDS);
    };

    Action askGoogleWhatToDo = (calledMethod, cause, actionLock, logger) -> {
        try {
            String answers = Jsoup.connect("https://www.google.com/search?q=How+to+handle+java+%s+stackoverflow".formatted(cause.getClass().getSimpleName())).get().select("span:not([class!=\"\"])")
                .stream()
                .map(Element::text)
                .flatMap(String::lines)
                .filter(text -> text.contains("exception"))
                .collect(Collectors.joining("\n\t", "[\n\t", "\n]"));

            logger.log(Level.INFO, "I don't know what to do now, but here are some google search results about '%s':\n%s".formatted(cause.getClass().getSimpleName(), answers));
        } catch (final IOException e) {
            logger.log(Level.INFO, "I can not connect to the Google, you are on your own :c");
        }

        actionLock.set(false);
    };
}
