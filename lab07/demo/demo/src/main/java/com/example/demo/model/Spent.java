package com.example.demo.model;

import com.example.demo.DTOModel.PaymentDTO;

import java.util.Collection;

public class Spent {
    private Collection<PaymentDTO> paymentsByCustomerId;

    public Collection<PaymentDTO> getPaymentsByCustomerId() {
        return paymentsByCustomerId;
    }

    public void setPaymentsByCustomerId(Collection<PaymentDTO> paymentsByCustomerId) {
        this.paymentsByCustomerId = paymentsByCustomerId;
    }
}
