package jaz.lab06.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import jaz.lab06.demo.credit.Credit;
import jaz.lab06.demo.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@Controller
public class MainController {
    CreditService creditService;

    @Autowired
    public MainController(CreditService creditService) {
        this.creditService = creditService;
    }

    @PostMapping(path="/credit/calculate", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Integer> addNewCredit(@RequestBody Credit creditData) {
        creditService.addNewCredit(creditData);
        return new ResponseEntity<>(creditData.getId(), HttpStatus.OK);
    }

    @GetMapping(path="/credit/timetable/{id}")
    public ResponseEntity<String> getCreditInJsonFormat(@PathVariable String id) throws JsonProcessingException {
        String json = creditService.getCreditInJsonFormat(id);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }

    @GetMapping(path="/credit/timetable/{id}&file=csv")
    public ResponseEntity<String> getCreditInCVSFormat(@PathVariable String id) throws IOException, IllegalAccessException {
        creditService.getCreditInCSVFormat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path="/credit/timetable/{id}&file=pdf")
    public ResponseEntity<String> getCreditInPDFFormat(@PathVariable String id) throws IOException, IllegalAccessException {
        creditService.getCreditInPDFFormat(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}