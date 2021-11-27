package com.example.demo;

import javax.persistence.*;
import java.util.List;

@Entity
public class ScheduleRow {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //it should be (serialIndex,idOfSchedule) but java is java not sql so i have no time to look for this :)
    int serialIndex;
    int idOfSchedule;
    double capital=0;
    double interest=0;
    double fixedFee=0;
    double capitalToPay=0;
    double amount=0;

    public ScheduleRow() {}

    public ScheduleRow(int serialIndex, double amount, int idOfSchedule) {
         this.serialIndex=serialIndex;
         this.amount=amount;
         this.idOfSchedule=idOfSchedule;
    }

    public ScheduleRow(int idOfSchedule, int serialIndex,double capital, double interest, double capitalToPay, double amount) {
        this.serialIndex = serialIndex;
        this.idOfSchedule = idOfSchedule;
        this.capital = capital;
        this.interest = interest;
        this.capitalToPay = capitalToPay;
        this.amount = amount;
    }

    public int getSerialIndex() {
        return serialIndex;
    }

    public void setSerialIndex(int serialIndex) {
        this.serialIndex = serialIndex;
    }

    public int getIdOfSchedule() {
        return idOfSchedule;
    }

    public void setIdOfSchedule(int idOfSchedule) {
        this.idOfSchedule = idOfSchedule;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public String[] toArray() {
        return new String[]{
                String.valueOf(serialIndex),
                String.valueOf(idOfSchedule),
                String.valueOf(capital),
                String.valueOf(interest),
                String.valueOf(fixedFee),
                String.valueOf(capitalToPay),
                String.valueOf(amount)
        };
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ScheduleRow{" +
                "id=" + id +
                ", serialIndex=" + serialIndex +
                ", idOfSchedule=" + idOfSchedule +
                ", capital=" + capital +
                ", interest=" + interest +
                ", fixedFee=" + fixedFee +
                ", capitalToPay=" + capitalToPay +
                ", amount=" + amount +
                '}';
    }
}
