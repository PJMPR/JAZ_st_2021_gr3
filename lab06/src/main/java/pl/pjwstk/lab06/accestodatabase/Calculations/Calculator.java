package pl.pjwstk.lab06.accestodatabase.Calculations;

import org.springframework.beans.factory.annotation.Autowired;
import pl.pjwstk.lab06.accestodatabase.Timetable.Credit;
import pl.pjwstk.lab06.accestodatabase.Repositories.InstalmentRepository;
import pl.pjwstk.lab06.accestodatabase.Timetable.Installment;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    @Autowired
    private InstalmentRepository timetableRepository;
    private Credit credit;
    private double capital = 0;


    public List<Installment> calculate(Credit credit){
        List<Installment> installments = new ArrayList<>();
        switch (credit.getInstallmentType()){
            case constant -> {
                double ammount = credit.getAmount();
                double capitaltopay = credit.getAmount();
                double fixedFee = ammount / credit.getPercentage();
                for(var i = 1; i <= credit.getInstallmentCount(); i++){
                    capital =  capital + ammount / credit.getInstallmentCount();
                    double interest = capitaltopay * credit.getPercentage();
                    capitaltopay = capitaltopay -capital;
                    double ammountTopay = fixedFee + interest;
                    installments.add(new Installment(capital, interest, fixedFee, capitaltopay, ammount,credit.getId()));
                }
            }
            case decreasing -> {
                System.out.println("chuj");
                return  null;
            }
        }
        return installments;
    }
}
