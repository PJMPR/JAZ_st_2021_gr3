package com.example.tests;

import org.example.SafeInvoker;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeoutException;

public class SafeInvokerTests {
    SafeInvoker safeInvoker = new SafeInvoker();

    @Test
    public void DatabaseExceptionTest(){
        //Utracono polaczenie z baza danych
        //Brak uprawnien do zasobow bazodanowych
        safeInvoker.invoke(() -> {throw new SQLException();});
    }

    @Test
    public void TimeoutExceptionTest(){
        //Utracono polaczenie z serwisem z ktorego sciagane sa dane programu
        safeInvoker.invoke(() -> {throw new TimeoutException();});
    }

    @Test
    public void InputOutputExceptionTest(){
        //Plik jest uzywany przez inny proces i nie da sie go w danej chwili otworczyc ani zapisac
        safeInvoker.invoke(() -> {throw new IOException();});
    }

    @Test
    public void FileNotFoundExceptionTest(){
        //Brak pliku w podanej sciezce
        safeInvoker.invoke(() -> {throw new FileNotFoundException();});
    }
}
