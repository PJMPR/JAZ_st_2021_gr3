package com.example.lab06.parameters;

import javax.persistence.Id;

public class Credit {

    @Id
    private int id;
    private double amount;
    private int installmentCount;
    private InstallmentType installmentType;
    private double percentage;
    private double fixedRate;

    public Credit(int id, double amount, int installmentCount, InstallmentType installmentType, double percentage, double fixedRate) {
        this.id = id;
        this.amount = amount;
        this.installmentCount = installmentCount;
        this.installmentType = installmentType;
        this.percentage = percentage;
        this.fixedRate = fixedRate;
    }

    public Credit() {

    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(int installmentCount) {
        this.installmentCount = installmentCount;
    }

    public InstallmentType getInstallmentType() {
        return installmentType;
    }

    public void setInstallmentType(InstallmentType installmentType) {
        this.installmentType = installmentType;
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(double fixedRate) {
        this.fixedRate = fixedRate;
    }
}
