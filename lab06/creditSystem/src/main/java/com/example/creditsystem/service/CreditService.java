package com.example.creditsystem.service;

import com.example.creditsystem.dto.CreditParams;
import com.example.creditsystem.dto.Timetable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CreditService {
    public Integer createCalculation(CreditParams creditParams) {
        //TODO dodać genarację calkulacji i zapis do bazy danych
        return new Integer(5);
    }

    public Timetable getTimetable(String id) {
//TODO dodać odczyt z bazy danych
        Timetable timetable = new Timetable();
        timetable.setNumber(5);
        timetable.setCapital(new BigDecimal(444));
        timetable.setInterest(new BigDecimal(444));
        timetable.setFixedFee(new BigDecimal(444));
        timetable.setCapitalToPay(new BigDecimal(444));
        timetable.setAmount(new BigDecimal(444));

        return timetable;
    }

}
