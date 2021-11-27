package jaz.lab06.demo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jaz.lab06.demo.credit.Credit;
import jaz.lab06.demo.exporters.CSVExporter;
import jaz.lab06.demo.exporters.PDFExporter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CreditService {
    CreditDataRepository creditDataRepository;

    @Autowired
    public CreditService(CreditDataRepository creditDataRepository) {
        this.creditDataRepository = creditDataRepository;
    }

    public void addNewCredit(Credit creditData) {
        creditData.count();
        creditDataRepository.save(creditData);
    }

    public String getCreditInJsonFormat(String id) throws JsonProcessingException {
        Credit creditData = creditDataRepository.findById(Integer.parseInt(id));
        return new ObjectMapper().writeValueAsString(creditData);
    }

    public void getCreditInCSVFormat(String id) throws IOException, IllegalAccessException {
        Credit creditData = creditDataRepository.findById(Integer.parseInt(id));
        new CSVExporter().createCSV(creditData);
    }

    public void getCreditInPDFFormat(String id) throws IOException, IllegalAccessException {
        Credit creditData = creditDataRepository.findById(Integer.parseInt(id));
        new PDFExporter().createPDF(creditData);
    }
}
