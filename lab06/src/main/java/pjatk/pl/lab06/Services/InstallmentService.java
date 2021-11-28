package pjatk.pl.lab06.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pjatk.pl.lab06.Loan.Installment;
import pjatk.pl.lab06.Loan.TimeTable;
import pjatk.pl.lab06.calculators.ConstantInstallmentCalc;
import pjatk.pl.lab06.calculators.DecreasingInstallmentCalc;
import pjatk.pl.lab06.repositories.InstallmentRepo;

import java.util.List;

@Service
public class InstallmentService {
    InstallmentRepo installmentRepo;
    ConstantInstallmentCalc constantInstallmentCalc;
    DecreasingInstallmentCalc decreasingInstallmentCalc;


    @Autowired
    public InstallmentService(InstallmentRepo installmentRepo, ConstantInstallmentCalc constantInstallmentCalc, DecreasingInstallmentCalc decreasingInstallmentCalc) {
        this.installmentRepo = installmentRepo;
        this.constantInstallmentCalc = constantInstallmentCalc;
        this.decreasingInstallmentCalc = decreasingInstallmentCalc;
    }


    public List<Installment> calculateInstallments(TimeTable timeTable){
        if (timeTable.getInstallmentType().toString().equals("decreasing")){
            return decreasingInstallmentCalc.calculator(timeTable);
        }
        else {
            return constantInstallmentCalc.calculator(timeTable);
        }
    }


    public void save(Installment installment){
        installmentRepo.save(installment);
    }

}
