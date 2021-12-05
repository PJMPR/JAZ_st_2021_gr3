package com.github.electroluxv2;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.StringJoiner;
import java.util.concurrent.TimeoutException;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SafeInvokerTest {

    static final Map<Class<? extends Exception>, UnsafeMethod> unsafeMethods = Map.of(
        Exception.class, () -> { throw new Exception(); },
        TimeoutException.class, () -> { throw new TimeoutException(); }
    );

    @Test
    public void unsafeMethodsShouldThrowExactlyOneException() {
        unsafeMethods.forEach((exception, unsafeMethod) -> {
            // Why? How, without introducing randomness, have I to test a few exceptions in one method?
            assertThrowsExactly(exception, unsafeMethod::invoke, "UnsafeMethod should throw exactly one exception.");
        });
    }

    @Test
    public void unsafeMethodsShouldBeThrown() {
        unsafeMethods.values().forEach(unsafeMethod -> {
            assertDoesNotThrow(() -> {
                SafeInvoker.INSTANCE.invoke(unsafeMethod);
            }, "UnsafeMethod exception should be thrown if exception occurred.");
        });
    }

    @Test
    public void shouldInvokeSameMethodNthTimes() throws Exception {
        final var spy = spy(new UnsafeMethod() { // Can't be lambda otherwise Mockito will explode
            @Override
            public void invoke() throws Exception {
                throw new TimeoutException();
            }
        });

        SafeInvoker.INSTANCE.setActionForException(TimeoutException.class, Action.repeatThreshold);
        SafeInvoker.INSTANCE.invoke(spy);

        verify(spy, times(10)).invoke();
    }

    @Test
    public void askGoogleActionShouldLogResults() {
        final var logs = new StringJoiner("");

        SafeInvoker.logger.addHandler(new Handler() {
            @Override
            public void publish(LogRecord record) {
                logs.add(record.getMessage());
            }

            @Override
            public void flush() { }

            @Override
            public void close() throws SecurityException { }
        });

        SafeInvoker.INSTANCE.setActionForException(Exception.class, Action.askGoogleWhatToDo);
        SafeInvoker.INSTANCE.invoke(unsafeMethods.get(Exception.class));

        assertTrue(logs.toString().contains("I don't know what to do now, but here are some google search results about"), "Ask Google action should return results");
    }
}
