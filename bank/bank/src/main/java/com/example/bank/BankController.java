package com.example.bank;

import com.example.bank.model.Credit;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class BankController {
    BankService bankService;

    @Autowired
    public BankController(final BankService bankService) {
        this.bankService = bankService;
    }

    @PostMapping("/credit/calculations/{id}")
    public ResponseEntity<Integer> calculate(@RequestBody Credit credit) {
        bankService.calculate(credit);
        return new ResponseEntity<>(credit.getId(), HttpStatus.OK);
    }

    @GetMapping("/credit/timetable/{id}")
    public ResponseEntity<String> getTimetableFromIdInFile(@PathVariable String id) throws JsonProcessingException {
        bankService.getHarmonogramInJson(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/credit/timetable/{id}&file={type}")
    public ResponseEntity<String> getTimetableFromIdInFile(@PathVariable String id, String type) throws IOException, IllegalAccessException {
        bankService.getHarmonogramInFile(id, type);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
