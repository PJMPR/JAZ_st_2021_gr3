package com.example.bank;

import com.example.bank.getfile.CSVGetter;
import com.example.bank.model.Credit;
import com.example.bank.model.Timetable;
import com.example.bank.repositories.CreditRepository;
import com.example.bank.repositories.TimetableRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BankService {
    CreditRepository creditRepository;
    TimetableRepository timetableRepository;

    @Autowired
    public BankService(CreditRepository creditRepository, TimetableRepository timetableRepository) {
        this.creditRepository = creditRepository;
        this.timetableRepository = timetableRepository;
    }

    public Timetable calculate(Credit credit) {
        for (int i = 0; i < credit.getInstallmentCount(); i++) {
            Timetable timetable = new Timetable();
            timetable.setNumber(i);
            timetable.setId(i);
            timetable.setAmount(credit.getAmount());
            timetable.setFixedFee(credit.getFixedFee());
            timetable.setInterest(credit.getPercentage() * timetable.getAmount());
            timetable.setCapital(timetable.getAmount() - (timetable.getNumber() * timetable.getInterest()));
            timetable.setCapitalToPay(timetable.getAmount() - ((timetable.getNumber() + 1) * timetable.getInterest()));
        }
    }

    public String getHarmonogramInJson(String id) throws JsonProcessingException {
        Credit credit = creditRepository.findById(Integer.parseInt(id));
        return new ObjectMapper().writeValueAsString(credit);
    }

    public void getHarmonogramInFile(String id, String type) throws IOException, IllegalAccessException {
        Credit credit = creditRepository.findById(Integer.parseInt(id));
        Timetable timetable = timetableRepository.findAll(credit.getId());
        if (type == "csv") {
            new CSVGetter().getFile(credit, timetable);
        } //else if(type == "pdf"){
        //new PDFGetter().getFile(credit, timetable);
        //}
    }
}
