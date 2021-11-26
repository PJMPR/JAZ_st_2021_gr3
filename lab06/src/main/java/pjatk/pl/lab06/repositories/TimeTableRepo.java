package pjatk.pl.lab06.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pjatk.pl.lab06.Loan.TimeTable;


@Repository
public interface TimeTableRepo extends CrudRepository<TimeTable, Long> {
    public TimeTable findById(long id);
}
