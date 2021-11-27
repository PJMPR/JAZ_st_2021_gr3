package com.example.creditsystem.controller;

import com.example.creditsystem.dto.AmountWithCurrency;
import com.example.creditsystem.dto.FileType;
import com.example.creditsystem.dto.Timetable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/credit")
public class CreditController {

    @GetMapping("/timetable/{id}")
    public Timetable getTimetable(@PathVariable String id, @RequestParam(required = false) FileType file) {

        Timetable timetable = new Timetable();
        timetable.setNumber(5);
        timetable.setCapital(new AmountWithCurrency(new BigDecimal(444), "PLN"));
        timetable.setInterest(new AmountWithCurrency(new BigDecimal(666), "PLN"));
        timetable.setFixedFee(new AmountWithCurrency(new BigDecimal(7777), "PLN"));
        timetable.setCapitalToPay(new AmountWithCurrency(new BigDecimal(42343), "PLN"));
        timetable.setAmount(new AmountWithCurrency(new BigDecimal(15464564), "PLN"));

        return timetable;
    }

}
