package com.github.electroluxv2.lab06.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.electroluxv2.lab06.entities.Credit;
import com.github.electroluxv2.lab06.entities.Installment;
import com.github.electroluxv2.lab06.entities.Views;
import com.github.electroluxv2.lab06.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankController {
    BankService bankService;

    @Autowired
    public BankController(final BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/credit/calculations")
    public ResponseEntity<Long> calculations(@RequestBody final Credit credit) {
        final var createdId = bankService.calculateCredit(credit);
        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @JsonView(Views.Public.class)
    @GetMapping("/credit/timetable/{id}")
    public ResponseEntity<List<Installment>> get(@PathVariable final long id) {
        return new ResponseEntity<>(bankService.getInstallmentsByCreditId(id), HttpStatus.OK);
    }
}
