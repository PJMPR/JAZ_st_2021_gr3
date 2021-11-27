package com.example.demo.Repositories;

import com.example.demo.Timetable.Installment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstallmentRepository extends CrudRepository<Installment, Integer> {
}
