package com.example.demo.statistics;

import java.math.BigDecimal;

public class CustomerStatistics {
    private int customerId;
    private String name;
    private String surname;
    public BigDecimal spentMoney;
    public int watchedMovies;

    public CustomerStatistics(int customerId, String name, String surname, BigDecimal spentMoney, int watchedMovies) {
        this.customerId = customerId;
        this.name = name;
        this.surname = surname;
        this.spentMoney = spentMoney;
        this.watchedMovies = watchedMovies;
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

    public BigDecimal getSpentMoney() {
        return spentMoney;
    }

    public void setSpentMoney(BigDecimal spentMoney) {
        this.spentMoney = spentMoney;
    }

    public int getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(int watchedMovies) {
        this.watchedMovies = watchedMovies;
    }
}
