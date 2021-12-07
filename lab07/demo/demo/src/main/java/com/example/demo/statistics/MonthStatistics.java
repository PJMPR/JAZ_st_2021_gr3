package com.example.demo.statistics;

public class MonthStatistics {
    private int month;
    private int borrowedMovies;

    public MonthStatistics(int month, int borrowedMovies) {
        this.month = month;
        this.borrowedMovies = borrowedMovies;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getBorrowedMovies() {
        return borrowedMovies;
    }

    public void setBorrowedMovies(int borrowedMovies) {
        this.borrowedMovies = borrowedMovies;
    }
}
