package com.example.demo.model.DTO;

import java.math.BigDecimal;

public class PaymentDTO {
    private BigDecimal amount;

    public PaymentDTO() {
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
