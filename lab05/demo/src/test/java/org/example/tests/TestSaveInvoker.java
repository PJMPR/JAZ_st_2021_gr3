package org.example.tests;

import org.example.SafeInvoker;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.sql.SQLInvalidAuthorizationSpecException;
import java.sql.SQLTimeoutException;


public class TestSaveInvoker {

    @Test
    public void FileErrorTest(){
        new SafeInvoker().invoke(() -> {throw new FileNotFoundException();});
    }

    @Test
    public void AuthorizationErrorTest{
        new SafeInvoker().invoke(() -> {throw new SQLInvalidAuthorizationSpecException();});
    }

    @Test
    public void TimeErrorTest{
        new SafeInvoker().invoke(() -> {throw new SQLTimeoutException();});
    }

    @Test
    public void UnknownErrorTest{
        new SafeInvoker().invoke(() -> {throw new Exception();});
    }

}
