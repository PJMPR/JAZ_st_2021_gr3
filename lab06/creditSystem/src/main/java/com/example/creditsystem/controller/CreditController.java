package com.example.creditsystem.controller;

import com.example.creditsystem.dto.CreditParams;
import com.example.creditsystem.dto.FileType;
import com.example.creditsystem.dto.Timetable;
import com.example.creditsystem.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/credit")
public class CreditController {

    private final CreditService creditService;

    @Autowired
    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping("/calculations" )
    public Integer calculations(@RequestBody CreditParams creditParams){
        return creditService.createCalculation(creditParams);
    }

    @GetMapping("/timetable/{id}")
    public Timetable getTimetable(@PathVariable String id, @RequestParam(required = false) FileType file) {
        Timetable timetable = creditService.getTimetable(id);

        //TODO dodać obsługę csv i pdf

        //Timetable timetable = new Timetable();

        return timetable;
    }

}
