package pjatk.pl.lab06.calculators;

import pjatk.pl.lab06.Loan.Installment;
import pjatk.pl.lab06.Loan.TimeTable;
import java.util.ArrayList;

public class DecreasingInstallmentCalc {
    public ArrayList<Installment> calculator(TimeTable timeTable){
        ArrayList<Installment> listOfInstallments = new ArrayList<>();
        double capital = 0;

        double installment = timeTable.getAmount() * timeTable.getPercentage() * Math.pow((timeTable.getPercentage() + 1), timeTable.getInstallmentCount())
                / (Math.pow((timeTable.getPercentage() +1 ), timeTable.getInstallmentCount()) - 1);

        for (int i = 0; i < timeTable.getInstallmentCount(); i++){
            double interest = timeTable.getAmount();
            double amount = installment - interest;
            double capitalToPay = timeTable.getAmount();
            listOfInstallments.add(new Installment(timeTable.getId(), i , capital, interest, timeTable.getFixedRate(), timeTable.getAmount(), amount));
            capital += amount;
            capitalToPay -= amount;

        }
        return  listOfInstallments;
    }
}
