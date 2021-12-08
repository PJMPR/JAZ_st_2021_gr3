package com.example.lab06.data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Customer {

    @Id
    private int customerId;

    private String name;
    private String surname;
    private Timestamp creteDate;
    private Timestamp lastUpdate;
    private List<Payment> paymentList;
    private List<Rental> rentalList;
    private double amountSpent;
    private int watchedMovies;

    public Customer(int customerId, String name, String surname, List<Rental> rentalList, double amountSpent, int watchedMovies) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.rentalList = rentalList;
        this.creteDate = creteDate;
        this.lastUpdate = lastUpdate;
        this.paymentList = paymentList;
        this.amountSpent = amountSpent;
        this.watchedMovies = watchedMovies;
    }

    public Customer(int customerId, String name, String surname, double amountSpent, int watchedMovies) {

    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    public Timestamp getCreteDate() {
        return creteDate;
    }

    public void setCreteDate(Timestamp creteDate) {
        this.creteDate = creteDate;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public double getAmountSpent() {
        Payment payment = new Payment();
        return payment.getAmount();
    }

    public void setAmountSpent(double amountSpent) {
        this.amountSpent = amountSpent;
    }

    public int getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(int watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public List<Rental> getRentalList() {
        return rentalList;
    }

    public void setRentalList(List<Rental> rentalList) {
        this.rentalList = rentalList;
    }
}
