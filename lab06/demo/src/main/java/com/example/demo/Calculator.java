package com.example.demo;

import java.util.ArrayList;

public class Calculator {

    public ArrayList<ScheduleRow> calculate(LoanRepaymentSchedule loanRepaymentSchedule) {
        double amount = loanRepaymentSchedule.getAmount();
        double percentage = loanRepaymentSchedule.getPercentage();
        int count = loanRepaymentSchedule.getInstallmentCount();

        ArrayList<ScheduleRow> scheduleRows = new ArrayList<ScheduleRow>();
        switch (loanRepaymentSchedule.getInstallmentType()) {
            case DECREASING -> {
                double totalPayed = 0;
                double toPayLeft = amount;//odsetki ?
                for (var i = 1; i <= count; i++) {
                    double rata = amount / count * Math.floor(1 + (count - i + 1) * percentage);
                    scheduleRows.add(new ScheduleRow(loanRepaymentSchedule.getNumber(), i, totalPayed, 0, toPayLeft, rata));
                    totalPayed += rata;
                    toPayLeft -= rata;
                }
            }
            case FIXED -> {
                double I = (amount * percentage) / (12 * (1 - Math.pow(12 / (12 + percentage), count)));
                double capitalPayed = 0;
                double capitalLeft = I;
                for (var i = 1; i <= count; i++) {
                    double interest = capitalLeft * percentage * 30 / 366;
                    scheduleRows.add(new ScheduleRow(loanRepaymentSchedule.getNumber(), i, capitalPayed, interest, capitalLeft, I));
                    capitalPayed += I;
                    capitalLeft -= I;
                }
            }
        }
        return scheduleRows;
    }
}
