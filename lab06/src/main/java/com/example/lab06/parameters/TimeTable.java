package com.example.lab06.parameters;

import javax.persistence.Id;

public class TimeTable {

    @Id
    private int capitalId;
    private int installmentNumber;
    private double capital;
    private double interest;
    private double fixedFee;
    private double capitalToPay;
    private double finalInstallmentAmount;

    public TimeTable(int capitalId, int installmentNumber, double capital, double interest, double fixedFee, double capitalToPay, double finalInstallmentAmount) {
        this.capitalId = capitalId;
        this.installmentNumber = installmentNumber;
        this.capital = capital;
        this.interest = interest;
        this.fixedFee = fixedFee;
        this.capitalToPay = capitalToPay;
        this.finalInstallmentAmount = finalInstallmentAmount;
    }

    public TimeTable() {
    }

    public int getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(int capitalId) {
        this.capitalId = capitalId;
    }

    public int getInstallmentNumber() {
        return installmentNumber;
    }

    public void setInstallmentNumber(int installmentNumber) {
        this.installmentNumber = installmentNumber;
    }

    public double getCapital() {
        return capital;
    }

    public void setCapital(double capital) {
        this.capital = capital;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(double fixedFee) {
        this.fixedFee = fixedFee;
    }

    public double getCapitalToPay() {
        return capitalToPay;
    }

    public void setCapitalToPay(double capitalToPay) {
        this.capitalToPay = capitalToPay;
    }

    public double getFinalInstallmentAmount() {
        return finalInstallmentAmount;
    }

    public void setFinalInstallmentAmount(double finalInstallmentAmount) {
        this.finalInstallmentAmount = finalInstallmentAmount;
    }
}
