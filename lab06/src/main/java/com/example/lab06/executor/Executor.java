package com.example.lab06.executor;

import com.example.lab06.Logic.Logic;
import com.example.lab06.parameters.Credit;
import com.example.lab06.parameters.TimeTable;
import com.example.lab06.repository.CreditRepository;
import com.example.lab06.repository.TimeTableRepository;
import com.example.lab06.schedules.WriteDataIntoCSV;
import com.example.lab06.schedules.WriteDataIntoPDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class Executor {
    private final CreditRepository creditRepository;
    private final TimeTableRepository timeTableRepository;
    private final Logic logic;

    @Autowired
    public Executor(CreditRepository creditRepository, TimeTableRepository timeTableRepository, Logic logic) {
        this.creditRepository = creditRepository;
        this.timeTableRepository = timeTableRepository;
        this.logic = logic;
    }

    public Credit getCredit(int id){
        return creditRepository.findById(id).orElse(null);
    }

    public TimeTable getTimeTable(int id){
        return timeTableRepository.findById(id).orElse(null);
    }

    public void estimateCredit(Credit credit, TimeTable timeTable){
        logic.logicMath();
        creditRepository.save(credit);
        timeTableRepository.save(timeTable);

        System.out.println(credit);
        System.out.println(timeTable);
    }

    public void getTimeTableCsv(int id) throws IllegalAccessException, IOException {
        new WriteDataIntoCSV().csvExport(getCredit(id), getTimeTable(id));
    }

    public void getTimetablePdf(int id) throws IllegalAccessException, IOException {
        new WriteDataIntoPDF().pdfExport(getCredit(id), getTimeTable(id));
    }
}
