package com.example.creditsystem.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class CreditParams {
    private BigDecimal amount;
    private BigDecimal installmentCount;
    private InstallmentType installmentType;
    private BigDecimal percentage;
    private BigDecimal fixedFee;

    public CreditParams() {
    }


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getInstallmentCount() {
        return installmentCount;
    }

    public void setInstallmentCount(BigDecimal installmentCount) {
        this.installmentCount = installmentCount;
    }

    public InstallmentType getInstallmentType() {
        return installmentType;
    }

    public void setInstallmentType(InstallmentType installmentType) {
        this.installmentType = installmentType;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(BigDecimal fixedFee) {
        this.fixedFee = fixedFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditParams that = (CreditParams) o;
        return Objects.equals(amount, that.amount) && Objects.equals(installmentCount, that.installmentCount) && installmentType == that.installmentType && Objects.equals(percentage, that.percentage) && Objects.equals(fixedFee, that.fixedFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, installmentCount, installmentType, percentage, fixedFee);
    }

    @Override
    public String toString() {
        return "CreditParams{" +
                "amount=" + amount +
                ", installmentCount=" + installmentCount +
                ", installmentType=" + installmentType +
                ", percentage=" + percentage +
                ", fixedFee=" + fixedFee +
                '}';
    }
}
