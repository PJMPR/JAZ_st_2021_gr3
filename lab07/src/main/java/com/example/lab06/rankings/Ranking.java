package com.example.lab06.rankings;

import com.example.lab06.data.Customer;

import java.util.List;

public class Ranking {
    private List<Customer> customerList;

    public Ranking(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public void addToRanking(Customer customer){
        customerList.add(new Customer(customer.getCustomerId(),customer.getName(),
                customer.getSurname(), customer.getAmountSpent(), customer.getWatchedMovies()));
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
