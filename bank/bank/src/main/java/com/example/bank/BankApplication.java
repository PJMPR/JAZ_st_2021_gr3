package com.example.bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class BankApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(BankApplication.class, args);
    }
}