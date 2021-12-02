package com.example.demo.controllers;


import java.math.BigDecimal;

record CustomerEntry(int id, String firstName, String lastName) {
    static CustomerEntry from(Object[] sqlRow) {
        return new CustomerEntry((short) sqlRow[0], (String) sqlRow[1], (String) sqlRow[2]);
    }
}
record CustomerRankingBySpentMoneyEntry(CustomerEntry customer, BigDecimal spent) {
    static CustomerRankingBySpentMoneyEntry from(Object[] sqlRow) {
        return new CustomerRankingBySpentMoneyEntry(CustomerEntry.from(sqlRow), (BigDecimal) sqlRow[3]);
    }
}
record CustomerRankingByWatchedMoviesEntry(CustomerEntry customer, short watched) {
    static CustomerRankingByWatchedMoviesEntry from(Object[] sqlRow) {
        return new CustomerRankingByWatchedMoviesEntry(CustomerEntry.from(sqlRow), (short) sqlRow[3]);
    }
}
