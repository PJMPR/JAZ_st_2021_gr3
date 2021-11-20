package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

@RunWith(MockitoJUnitRunner.class)
public class SafeInvokerTest {

    @InjectMocks
    private SafeInvoker safeInvoker;

    @Test
    public void ThrowDefaultException(){
        safeInvoker.invoke(() -> { throw new Exception(); });
    }

    @Test
    public void ThrowFileNotFoundException(){
        safeInvoker.invoke(() -> { throw new FileNotFoundException(); });
    }

    @Test
    public void ThrowIOException(){
        safeInvoker.invoke(() -> { throw new IOException(); });
    }

    @Test
    public void ThrowSQLException(){
        safeInvoker.invoke(() -> { throw new SQLException(); });
    }

    @Test
    public void ThrowTimeoutException(){
        safeInvoker.invoke(() -> { throw new TimeoutException(); });
    }
}