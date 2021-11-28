package pjatk.pl.lab06.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pjatk.pl.lab06.Loan.TimeTable;
import pjatk.pl.lab06.repositories.TimeTableRepo;

@Service
public class TimeTableService {
    TimeTableRepo timeTableRepo;

    @Autowired
    public TimeTableService(TimeTableRepo timeTableRepo) {
        this.timeTableRepo = timeTableRepo;
    }

    public Long insertData(TimeTable timeTable){
        timeTableRepo.save(timeTable);
        return timeTable.getId();
    }

    public TimeTable getTimetable(int id){
        return timeTableRepo.findById(id);
    }
}
