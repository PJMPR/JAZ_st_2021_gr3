package com.example.demo.Services;

import com.example.demo.Calculator.Calculator;
import com.example.demo.Repositories.TimetableRepository;
import com.example.demo.Timetable.Installment;
import com.example.demo.Timetable.Timetable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TimetableService {
    TimetableRepository timetableRepository;
    Calculator calculator;

    @Autowired
    public TimetableService(TimetableRepository timetableRepository, Calculator calculator) {
        this.timetableRepository = timetableRepository;
        this.calculator = calculator;
    }

    public void insertData(Timetable timetable) {
        timetableRepository.save(timetable);
    }

    public Timetable getTimetable(int id) {
        return timetableRepository.findById(id);
    }

    public List<Installment> calculateInstalments(Timetable timetable) {
        return calculator.calculate(timetable);
    }

    public Timetable findTimetableById(int id) {
        return timetableRepository.findById(id);
    }
}
