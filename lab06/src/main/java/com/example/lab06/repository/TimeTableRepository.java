package com.example.lab06.repository;

import com.example.lab06.parameters.TimeTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeTableRepository extends CrudRepository<TimeTable, Integer> {
}
