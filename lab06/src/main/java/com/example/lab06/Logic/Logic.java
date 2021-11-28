package com.example.lab06.Logic;

import com.example.lab06.parameters.Credit;
import com.example.lab06.parameters.TimeTable;
import org.springframework.stereotype.Component;

@Component
public class Logic {

    public void logicMath(){
        Credit credit = new Credit();
        TimeTable timeTable = new TimeTable();

        timeTable.setInterest(credit.getAmount() * credit.getPercentage());
        timeTable.setFinalInstallmentAmount(credit.getAmount() / credit.getInstallmentCount() + timeTable.getInterest());
        timeTable.setCapital(timeTable.getInstallmentNumber() * timeTable.getFinalInstallmentAmount());
        timeTable.setCapitalToPay(credit.getAmount() - timeTable.getCapital());
        timeTable.setFixedFee(timeTable.getFixedFee());
    }
}
