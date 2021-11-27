package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends CrudRepository<LoanRepaymentSchedule,Integer> {
    List<LoanRepaymentSchedule> findByNumber(int loanId);
}
