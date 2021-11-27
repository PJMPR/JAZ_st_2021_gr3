package com.example.bank.repositories;

import com.example.bank.model.Timetable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableRepository extends CrudRepository<Timetable, Integer> {
    Timetable findAll(int id);
}
