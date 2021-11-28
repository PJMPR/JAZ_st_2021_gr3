package Lab06.Service;

import Lab06.Credit.Credit;
import Lab06.FilesBuilders.CSVExporter;
import Lab06.Repository.CreditRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.IOException;

@Component
public class Service {
    private CreditRepository repository;

    @Autowired
    public Service(CreditRepository creditRepository) {
        this.repository = creditRepository;
    }


    public void evaluateCredit(Credit credit) {

        credit.doTheMath();
        repository.save(credit);

        System.out.println(credit);

    }

    public String getTimeTableJson(int id) throws JsonProcessingException {
        Credit creditFromDB =  repository.findById(id).orElse(null);
        return new ObjectMapper().writeValueAsString(creditFromDB);
    }


    public void getTimeTableCVS(int id) throws  IOException, IllegalAccessException {
        Credit creditFromDB = repository.findById(id).orElse(null);
        new CSVExporter().createCSV(creditFromDB);
    }

    public void getTImeTablePDF(int id ) throws IOException, IllegalAccessException {
        Credit creditFromDb = repository.findById(id).orElse(null);
        new jaz.lab06.demo.exporters.PDFExporter().createPDF(creditFromDb);
    }
}
