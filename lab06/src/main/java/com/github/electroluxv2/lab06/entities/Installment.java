package com.github.electroluxv2.lab06.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(InstallmentId.class)
@Table(name = "installments")
public class Installment {
    @Id
    private long creditId;

    @Id
    private long number;

    private double capital;
    private double interest;
    private double fixedFee;
    private double capitalToPay;
    private double amount;

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
}
