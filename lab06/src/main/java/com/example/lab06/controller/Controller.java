package com.example.lab06.controller;

import com.example.lab06.executor.Executor;
import com.example.lab06.parameters.Credit;
import com.example.lab06.parameters.TimeTable;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class Controller {
    private Executor executor;

    @Autowired
    public Controller(Executor executor) {
        this.executor = executor;
    }

    @PostMapping(path = "/credit/calculator")
    public ResponseEntity<?> addNewCredit(@RequestBody Credit credit, TimeTable timeTable){
        executor.estimateCredit(credit, timeTable);
        return new ResponseEntity<>(credit.getId(), HttpStatus.OK);
    }

    @GetMapping("/credit/{id}")
    public Credit getSingleCredit(@PathVariable int id){
        return executor.getCredit(id);
    }

    @GetMapping(path = "/credit/timetable/{id}&file=csv")
    public ResponseEntity<Integer> getCsv(@PathVariable int id) throws IllegalAccessException, IOException {
        executor.getTimeTableCsv(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(path = "/credit/timetable/{id}%file=pdf")
    public ResponseEntity<Integer> getPdf(@PathVariable int id) throws IllegalAccessException, IOException {
        executor.getTimetablePdf(id);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
