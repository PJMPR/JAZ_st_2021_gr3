package pjatk.pl.lab06.calculators;

import pjatk.pl.lab06.Loan.Installment;
import pjatk.pl.lab06.Loan.TimeTable;

import java.util.ArrayList;

public class ConstantInstallmentCalc {
    public ArrayList<Installment> calculator(TimeTable timeTable) {
        ArrayList<Installment> listOfInstallments = new ArrayList<>();
        double capital = 0;

        double totalInterest = (timeTable.getPercentage() * timeTable.getAmount()) + (timeTable.getFixedRate() * timeTable.getInstallmentCount());
        double monthlyInterest = totalInterest / timeTable.getInstallmentCount();
        double capitalToPay = totalInterest + timeTable.getAmount();
        double installment = capitalToPay / timeTable.getInstallmentCount();

        for (int i = 0; i < timeTable.getInstallmentCount(); i++){
            listOfInstallments.add(new Installment(timeTable.getId(), i, capital, monthlyInterest, timeTable.getFixedRate(), capitalToPay, installment));
            capital += installment;
            capitalToPay -= installment;
        }


        return listOfInstallments;
    }
}
