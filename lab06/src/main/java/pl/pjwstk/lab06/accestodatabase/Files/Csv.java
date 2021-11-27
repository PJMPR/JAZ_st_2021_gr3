package pl.pjwstk.lab06.accestodatabase.Files;

import org.springframework.stereotype.Component;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import pl.pjwstk.lab06.accestodatabase.Repositories.InstalmentRepository;
import pl.pjwstk.lab06.accestodatabase.Timetable.Installment;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class Csv {
    public static void getFile(HttpServletResponse response, int id, InstalmentRepository instalmentRepository) throws IOException {
        response.setContentType("text/csv");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".csv";
        response.setHeader(headerKey, headerValue);

        List<Installment> installmentList = instalmentRepository.findById(id).stream().toList();

        ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = {"Number", "percentage of capital", "capital to pay", "fixed fee", "interest", "amount"};
        String[] nameMapping = {"number", "capital", "capitalToPay", "fixedFee", "interest", "amount"};

        csvWriter.writeHeader(csvHeader);

        for (Installment installment : installmentList) {
            csvWriter.write(installment, nameMapping);
        }

        csvWriter.close();
    }
}
