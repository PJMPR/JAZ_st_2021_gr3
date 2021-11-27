package com.example.demo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.*;

@Controller
public class MainController {
    final ScheduleService scheduleService;

    public MainController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping ("/credit/calculations/{amount}&{installmentCount}&{installmentType}&{percentage}&{fixedFee}")
    public ResponseEntity<?> test(@PathVariable String amount, @PathVariable String installmentCount, @PathVariable String installmentType, @PathVariable String percentage, @PathVariable String fixedFee) {
        var schedule = new LoanRepaymentSchedule(Double.parseDouble(amount), Integer.parseInt(installmentCount), InstallmentTypes.getType(installmentType), Double.parseDouble(percentage), Integer.parseInt(fixedFee));
        var index = scheduleService.addSchedule(schedule);
        return new ResponseEntity<>(index, HttpStatus.OK);
    }

    @GetMapping ("/credit/calculations/{amount}&{installmentCount}&{installmentType}&{percentage}&{fixedFee}")
    public ResponseEntity<?> test1(@PathVariable String amount, @PathVariable String installmentCount, @PathVariable String installmentType, @PathVariable String percentage, @PathVariable String fixedFee) {
        var schedule = new LoanRepaymentSchedule(Double.parseDouble(amount), Integer.parseInt(installmentCount), InstallmentTypes.getType(installmentType), Double.parseDouble(percentage), Integer.parseInt(fixedFee));
        var index = scheduleService.addSchedule(schedule);
        return new ResponseEntity<>(index, HttpStatus.OK);
    }

    @GetMapping("/credit/timetable/{id}/{type}/")
    public ResponseEntity<?> getScheduleAsSomething(@PathVariable String id, @PathVariable String type) {
        var schedule = scheduleService.getSchedule(Integer.parseInt(id));
        var scheduleRows = scheduleService.getScheduleRows(Integer.parseInt(id));
        var test = new ScheduleResponse(schedule, scheduleRows);



        if (type.equals("pdf")) {
            Document document = scheduleService.generatePDF(test);
            return new ResponseEntity<>(document, HttpStatus.OK);
        } else {
            CSVWriter writer = null;
            try  {
                writer = new CSVWriter(new FileWriter("iTextHelloWorld.csv"));
                CSVWriter finalWriter = writer;
                scheduleRows.forEach(scheduleRow -> {
                    finalWriter.writeNext(scheduleRow.toArray());
                });

            } catch (IOException e) {
                e.printStackTrace();
            }
            return new ResponseEntity<>(writer, HttpStatus.OK);
        }

    }

    @GetMapping("/credit/timetable/{id}/")
    public ResponseEntity<?> getSchedule(@PathVariable String id) {
        var schedule = scheduleService.getSchedule(Integer.parseInt(id));
        var scheduleRows = scheduleService.getScheduleRows(Integer.parseInt(id));
        return new ResponseEntity<>(new ScheduleResponse(schedule, scheduleRows), HttpStatus.OK);
    }

}
