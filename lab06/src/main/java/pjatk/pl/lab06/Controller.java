package pjatk.pl.lab06;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pjatk.pl.lab06.Loan.Installment;
import pjatk.pl.lab06.Loan.TimeTable;
import pjatk.pl.lab06.Services.InstallmentService;
import pjatk.pl.lab06.Services.TimeTableService;
import pjatk.pl.lab06.writers.WriteDataIntoCSV;
import pjatk.pl.lab06.writers.WriteDataIntoPdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {
    InstallmentService installmentService;
    TimeTableService timeTableService;
    WriteDataIntoCSV writeDataIntoCSV;
    WriteDataIntoPdf writeDataIntoPdf;

    @Autowired
    public Controller(InstallmentService installmentService, TimeTableService timeTableService, WriteDataIntoCSV writeDataIntoCSV, WriteDataIntoPdf writeDataIntoPdf) {
        this.installmentService = installmentService;
        this.timeTableService = timeTableService;
        this.writeDataIntoCSV = writeDataIntoCSV;
        this.writeDataIntoPdf = writeDataIntoPdf;
    }

    @PostMapping(path = "/credit/calculate")
    public long saveInstallment(TimeTable timeTable){
        long id = timeTableService.insertData(timeTable);
        List<Installment> installments = new ArrayList<>(installmentService.calculateInstallments(timeTable));
        installments.forEach(installment -> installmentService.save(installment));
        return id;
    }

    @GetMapping(path = "/credit/timetable")
    public TimeTable getTimeTable(Integer id){
        return timeTableService.getTimetable(id);
    }

    @GetMapping(path = "/credit/timetable/{id}&file=csv")
    public void csvWriteIntoFile(Integer id){
        WriteDataIntoCSV.writeDataIntoCsvMethod(timeTableService,id);
    }
    @GetMapping(path = "/credit/timetable/{id}&file=pdf")
    public void pdfWriteIntoFile(Integer id) throws IOException {
        WriteDataIntoPdf.writeDataIntoPdfMethod(id, timeTableService);
    }


}
