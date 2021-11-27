package com.github.electroluxv2.lab06.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.github.electroluxv2.lab06.entities.Credit;
import com.github.electroluxv2.lab06.entities.Views;
import com.github.electroluxv2.lab06.exporters.Exporter;
import com.github.electroluxv2.lab06.services.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
    public ResponseEntity<byte[]> get(@PathVariable final long id, @RequestParam("file") final Optional<String> file) throws Exception {
        final var installments = bankService.getInstallmentsByCreditId(id);
        final var exporter = Exporter.exporters.get(file.orElse("json"));
        final var contentType = exporter.getKey();
        final var content = exporter.getValue().export(installments);
        final var headers = new HttpHeaders();
        headers.setContentType(contentType);
        return new ResponseEntity<>(content, headers, HttpStatus.OK);
    }
}
