package com.example.demo;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Component
public class ScheduleService {
    private final ScheduleRowRepository scheduleRowRepository;
    private final ScheduleRepository scheduleRepository;
    private final Calculator calculator = new Calculator();

    @Autowired
    public ScheduleService(ScheduleRowRepository scheduleRowRepository, ScheduleRepository scheduleRepository) {
        this.scheduleRowRepository = scheduleRowRepository;
        this.scheduleRepository = scheduleRepository;

    }

    public int addSchedule(LoanRepaymentSchedule schedule) {
        scheduleRepository.save(schedule);
        var rows = calculator.calculate(schedule);
        scheduleRowRepository.saveAll(rows);
        return schedule.getNumber();
    }

    public LoanRepaymentSchedule getSchedule(int number) {
        return scheduleRepository.findById(number).orElse(null);
    }

    public Iterable<ScheduleRow> getScheduleRows(int number) {
        return scheduleRowRepository.findAllByIdOfSchedule(number);
    }

    public Document generatePDF(ScheduleResponse scheduleResponse){
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        }

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk(String.valueOf(scheduleResponse), font);

        try {
            document.add(chunk);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        document.close();
        return document;
    }
}
