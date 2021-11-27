package com.github.electroluxv2.lab06.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(InstallmentId.class)
@Table(name = "installments")
@JsonPropertyOrder({"number", "capital", "interest", "fixedFee", "amount", "capitalToPay"})
public class Installment {
    @Id
    private long creditId;
    @Id
    @JsonView(Views.Public.class)
    private long number;
    @JsonView(Views.Public.class)
    private double capital;
    @JsonView(Views.Public.class)
    private double interest;
    @JsonView(Views.Public.class)
    private double fixedFee;
    @JsonView(Views.Public.class)
    private double amount;
    @JsonView(Views.Public.class)
    private double capitalToPay;

    public Installment() { }

    public Installment(long creditId, long number, double capital, double interest, double fixedFee, double capitalToPay, double amount) {
        this.creditId = creditId;
        this.number = number;
        this.capital = capital;
        this.interest = interest;
        this.fixedFee = fixedFee;
        this.capitalToPay = capitalToPay;
        this.amount = amount;
    }

    public double getCapital() {
        return capital;
    }

    public double getInterest() {
        return interest;
    }

    public double getFixedFee() {
        return fixedFee;
    }

    public double getCapitalToPay() {
        return capitalToPay;
    }

    public double getAmount() {
        return amount;
    }

    public long getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return ("""
                #%d
                %.2f
                %.2f
                %.2f
                %.2f
                %.2f
                """).formatted(number, capital, interest, fixedFee, amount, capitalToPay);
    }
}
