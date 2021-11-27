package com.example.bank.repositories;

import com.example.bank.model.Credit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Integer> {
    Credit findById(int id);
}
