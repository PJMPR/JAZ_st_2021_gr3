package com.example.demo.controllers;

import com.example.demo.model.Customer;

public record CustomerEntry(int customer_id, String first_name, String last_name) {

    static CustomerEntry from(Customer customer) {
        return new CustomerEntry(customer.getCustomerId(), customer.getFirstName(), customer.getLastName());
    }
}
