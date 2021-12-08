package com.example.lab06.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Payment {

    @Id
    private int paymentId;

    private double amount;
    private Timestamp date;
    private Timestamp lastUpdate;

    public Payment(int paymentId, double amount, Timestamp date, Timestamp lastUpdate) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.date = date;
        this.lastUpdate = lastUpdate;
    }

    public Payment() {

    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
