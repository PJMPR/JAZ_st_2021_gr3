package com.example.demo.Calculator;

import com.example.demo.Timetable.Installment;
import com.example.demo.Timetable.Timetable;
import org.apache.commons.math3.util.Precision;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Calculator {
    public List<Installment> calculate(Timetable t) {
        List<Installment> installments = new ArrayList<>();
        switch (t.getInstallmentType()) {
            case constant -> constantCalc(t, installments);
            case decreasing -> decreasingCalc(t, installments);
        }


        return installments;
    }

    private void decreasingCalc(Timetable t, List<Installment> installments) {
        double capitalToPay = t.getAmount();
        double percentage = t.getPercentage();
        double amount, capital = 0;
        int number = t.getInstallmentCount();
        for (int i = 1; i <= number; i++) {
            double interest = capitalToPay * percentage;
            amount = t.getFixedFee() + interest;
            installments.add(new Installment(t.getId(), i, Precision.round(capital, 2), Precision.round(interest, 2), t.getFixedFee(), Precision.round(capitalToPay, 2), Precision.round(amount, 2)));
            capital += amount;
            capitalToPay -= amount;
        }
    }

    private void constantCalc(Timetable t, List<Installment> installments) {
        int number = t.getInstallmentCount();
        double capital = 0;
        double interest = t.getAmount() * t.getPercentage() / t.getInstallmentCount();
        double capitalToPay = t.getAmount();
        double amount = capitalToPay / t.getInstallmentCount();
        for (int i = 1; i <= number; i++) {
            installments.add(new Installment(t.getId(), i, Precision.round(capital, 2), Precision.round(interest, 2), t.getFixedFee(), Precision.round(capitalToPay, 2), Precision.round(amount, 2)));
            capital += amount;
            capitalToPay -= amount;
        }
    }
}
