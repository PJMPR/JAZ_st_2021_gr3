package com.github.electroluxv2;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;
import java.util.concurrent.TimeoutException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
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
}
