package com.example.demo.model;

import java.util.List;

public class YearRents {
    private List<MonthRents> monthRents;

    public List<MonthRents> getMonthRents() {
        return monthRents;
    }

    public void setMonthRents(List<MonthRents> monthRents) {
        this.monthRents = monthRents;
    }
}
