package com.example.demo;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class LoanRepaymentSchedule {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    int number;

    double amount;
    int installmentCount;

    @Enumerated(EnumType.STRING)
    InstallmentTypes installmentType;
    double percentage;
    int fixedRate;

    public LoanRepaymentSchedule() {}

    public LoanRepaymentSchedule(double amount, int installmentCount, InstallmentTypes installmentType, double percentage, int fixedRate) {
        this.amount = amount;
        this.installmentCount = installmentCount;
        this.installmentType = installmentType;
        this.percentage = percentage;
        this.fixedRate = fixedRate;
    }

    public double getAmount() {
        return amount;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setInstallmentCount(int installmentCount) {
        this.installmentCount = installmentCount;
    }

    public void setInstallmentType(InstallmentTypes installmentType) {
        this.installmentType = installmentType;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public void setFixedRate(int fixedRate) {
        this.fixedRate = fixedRate;
    }

    public int getInstallmentCount() {
        return installmentCount;
    }

    public InstallmentTypes getInstallmentType() {
        return installmentType;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getFixedRate() {
        return fixedRate;
    }

    @Override
    public String toString() {
        return "LoanRepaymentSchedule{" +
                "number=" + number +
                ", amount=" + amount +
                ", installmentCount=" + installmentCount +
                ", installmentType=" + installmentType +
                ", percentage=" + percentage +
                ", fixedRate=" + fixedRate +
                '}';
    }
}
