package com.example.demo.results;

import com.example.demo.DTOModel.CustomerDTO;
import com.example.demo.DTOModel.PaymentDTO;
import com.example.demo.model.Spent;

import java.math.BigDecimal;

public class CustomerStats {
    CustomerDTO customer;
    BigDecimal spent;
    long watched;


    public CustomerStats(CustomerDTO customer, Spent spent) {
        this.customer = customer;
        this.spent = spent.getPaymentsByCustomerId().stream().map(PaymentDTO::getAmount).reduce(BigDecimal.valueOf(0), BigDecimal::add);
        this.watched = spent.getPaymentsByCustomerId().size();
    }

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = customer;
    }

    public BigDecimal getSpent() {
        return spent;
    }

    public void setSpent(BigDecimal spent) {
        this.spent = spent;
    }

    public long getWatched() {
        return watched;
    }

    public void setWatched(long watched) {
        this.watched = watched;
    }
}
