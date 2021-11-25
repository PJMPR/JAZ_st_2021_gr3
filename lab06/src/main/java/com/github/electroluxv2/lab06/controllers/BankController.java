package com.github.electroluxv2.lab06.controllers;

import com.github.electroluxv2.lab06.entities.Installment;
import com.github.electroluxv2.lab06.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankController {
    BankService bankService;

    @Autowired
    public BankController(final BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/add")
    public ResponseEntity<Long> add() {
        long createdId = bankService.add();

        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<Installment>> get(@PathVariable final long id) {
        return new ResponseEntity<>(bankService.getByCreditId(id), HttpStatus.OK);
    }
}
