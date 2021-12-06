package com.example.demo.model.DTO;

import com.example.demo.model.Payment;
import com.example.demo.model.Rental;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import static org.apache.coyote.http11.Constants.a;

@Data
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(value = {"paymentsByCustomerId", "rentalsByCustomerId"})
public class CustomerDTO {

    private int customerId;
    private String firstName;
    private String lastName;
    private Collection<PaymentDTO> paymentsByCustomerId;
    private Collection<RentalDTO> rentalsByCustomerId;
    private BigDecimal spent = BigDecimal.valueOf(0);

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

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
    public void calculatePayments(){

        for(PaymentDTO paymendDt : paymentsByCustomerId){
            spent.add(paymendDt.getAmount());
        }
    }

}

