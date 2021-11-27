package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRowRepository extends CrudRepository<ScheduleRow,Integer> {
    List<ScheduleRow> findAllByIdOfSchedule(int id);
}
