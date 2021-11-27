package com.example.creditsystem.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Timetable {

    private Integer number;
    private BigDecimal capital;
    private BigDecimal interest;
    private BigDecimal fixedFee;
    private BigDecimal capitalToPay;
    private BigDecimal amount;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public BigDecimal getCapital() {
        return capital;
    }

    public void setCapital(BigDecimal capital) {
        this.capital = capital;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(BigDecimal fixedFee) {
        this.fixedFee = fixedFee;
    }

    public BigDecimal getCapitalToPay() {
        return capitalToPay;
    }

    public void setCapitalToPay(BigDecimal capitalToPay) {
        this.capitalToPay = capitalToPay;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timetable timetable = (Timetable) o;
        return Objects.equals(number, timetable.number) && Objects.equals(capital, timetable.capital) && Objects.equals(interest, timetable.interest) && Objects.equals(fixedFee, timetable.fixedFee) && Objects.equals(capitalToPay, timetable.capitalToPay) && Objects.equals(amount, timetable.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, capital, interest, fixedFee, capitalToPay, amount);
    }

    @Override
    public String toString() {
        return "Timetable{" +
                "number=" + number +
                ", capital=" + capital +
                ", interest=" + interest +
                ", fixedFee=" + fixedFee +
                ", capitalToPay=" + capitalToPay +
                ", amount=" + amount +
                '}';
    }
}
