package pjatk.pl.lab06.writers;

import com.opencsv.CSVWriter;
import org.springframework.stereotype.Component;
import pjatk.pl.lab06.Loan.Installment;
import pjatk.pl.lab06.Services.TimeTableService;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Component
public class WriteDataIntoCSV {

    public static void writeDataIntoCsvMethod(TimeTableService timeTableService, int id){

        try {
            FileWriter fileWriter = new FileWriter("/src/main/resources/installmentCSV.csv");

            CSVWriter writer = new CSVWriter(fileWriter);

            List<Installment> installmentList = timeTableService.getTimetable(id).getInstallments();

            String[] header = {"id", "amount", "InstallmentCount", "InstallmentType", "Percentage","FixedRate"};
            writer.writeNext(header);
            for (Installment installment : installmentList){
                writer.writeNext(new String[]{installment.toString()});
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
