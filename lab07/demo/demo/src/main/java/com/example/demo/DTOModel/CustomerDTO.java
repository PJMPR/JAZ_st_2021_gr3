package com.example.demo.DTOModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.math.BigDecimal;
import java.util.Collection;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(value = { "customerPayments", "customerRentals" })
public class CustomerDTO {
    private int customerId;
    private String firstName;
    private String lastName;
    private Collection<PaymentDTO> customerPayments;
    private Collection<RentalDTO> customerRentals;
    private BigDecimal spent;
    private long watched;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<PaymentDTO> getCustomerPayments() {
        return customerPayments;
    }

    public void setCustomerPayments(Collection<PaymentDTO> customerPayments) {
        this.customerPayments = customerPayments;
    }

    public Collection<RentalDTO> getCustomerRentals() {
        return customerRentals;
    }

    public void setCustomerRentals(Collection<RentalDTO> customerRentals) {
        this.customerRentals = customerRentals;
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
