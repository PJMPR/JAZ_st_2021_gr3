package com.example.demo.Controllers;

import com.example.demo.FileExport.CsvFile;
import com.example.demo.FileExport.PdfFile;
import com.example.demo.Services.InstallmentService;
import com.example.demo.Services.TimetableService;
import com.example.demo.Timetable.Installment;
import com.example.demo.Timetable.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class Controller {
    InstallmentService installmentService;
    TimetableService timetableService;
    PdfFile pdfFile;
    CsvFile csvFile;

    @Autowired
    public Controller(InstallmentService installmentService, TimetableService timetableService, PdfFile pdfFile, CsvFile csvFile) {
        this.installmentService = installmentService;
        this.timetableService = timetableService;
        this.pdfFile = pdfFile;
        this.csvFile = csvFile;
    }

    @PostMapping("credit/calculations")
    public long saveInstallmentData(@RequestBody Timetable timetable) {
        timetableService.insertData(timetable);
        List<Installment> installmentList = timetableService.calculateInstalments(timetable);
        installmentList.forEach(installment -> installmentService.saveInstallments(installment));
        return timetable.getId();
    }

    @GetMapping(value = "credit/timetable", params = "id")
    public Timetable getTimetable(@RequestParam Integer id) {
        return timetableService.getTimetable(id);
    }

    @GetMapping(value = "/credit/timetable", params = {"id", "file"})
    public void getFile(HttpServletResponse response, @RequestParam Integer id, @RequestParam String file) throws IOException {
        switch (file) {
            case "pdf" -> PdfFile.getFile(response, id, timetableService);
            case "csv" -> CsvFile.getFile(response, id, timetableService);
        }
    }
}
