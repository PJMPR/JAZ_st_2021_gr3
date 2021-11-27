package com.example.creditsystem.dto;

import java.util.Objects;

public class Timetable {

    private Integer number;
    private AmountWithCurrency capital;
    private AmountWithCurrency interest;
    private AmountWithCurrency fixedFee;
    private AmountWithCurrency capitalToPay;
    private AmountWithCurrency amount;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public AmountWithCurrency getCapital() {
        return capital;
    }

    public void setCapital(AmountWithCurrency capital) {
        this.capital = capital;
    }

    public AmountWithCurrency getInterest() {
        return interest;
    }

    public void setInterest(AmountWithCurrency interest) {
        this.interest = interest;
    }

    public AmountWithCurrency getFixedFee() {
        return fixedFee;
    }

    public void setFixedFee(AmountWithCurrency fixedFee) {
        this.fixedFee = fixedFee;
    }

    public AmountWithCurrency getCapitalToPay() {
        return capitalToPay;
    }

    public void setCapitalToPay(AmountWithCurrency capitalToPay) {
        this.capitalToPay = capitalToPay;
    }

    public AmountWithCurrency getAmount() {
        return amount;
    }

    public void setAmount(AmountWithCurrency amount) {
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
