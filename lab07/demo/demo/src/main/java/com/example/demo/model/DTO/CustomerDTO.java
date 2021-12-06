package com.example.demo.model.DTO;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;


@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(value = {"paymentsByCustomerId", "rentalsByCustomerId"})
public class CustomerDTO {

    private int customerId;
    private String firstName;
    private String lastName;
    private BigDecimal spent;
    private int watched;
    private Collection<PaymentDTO> paymentsByCustomerId;
    private Collection<RentalDTO> rentalsByCustomerId;

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

    public BigDecimal getSpent() {
        return spent;
    }

    public void setSpent(BigDecimal spent) {
        this.spent = spent;
    }

    public int getWatched() {
        return watched;
    }

    public void setWatched(int watched) {
        this.watched = watched;
    }

    public BigDecimal calculatePayments(){
        return paymentsByCustomerId.stream().map(PaymentDTO::getAmount)
                .reduce(BigDecimal.valueOf(0), BigDecimal::add);
    }
    public int calcuateMovies(){
        return paymentsByCustomerId.size();
    }
}

