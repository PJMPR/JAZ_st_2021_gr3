package com.github.electroluxv2.lab06.controller;

import com.github.electroluxv2.lab06.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditController {
    CreditService creditService;

    @Autowired
    public CreditController(final CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping("/add")
    public ResponseEntity<Long> addCar() {
        long createdId = creditService.add();

        return new ResponseEntity<>(createdId, HttpStatus.CREATED);
    }
}
