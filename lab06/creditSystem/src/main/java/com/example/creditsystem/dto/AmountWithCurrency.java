package com.example.creditsystem.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class AmountWithCurrency {

    private BigDecimal amount;

    private String currency;

    public AmountWithCurrency(){}


    public AmountWithCurrency(BigDecimal amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AmountWithCurrency that = (AmountWithCurrency) o;
        return Objects.equals(amount, that.amount) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, currency);
    }

    @Override
    public String toString() {
        return "AmountWithCurrency{" +
                "amount=" + amount +
                ", currency='" + currency + '\'' +
                '}';
    }
}
