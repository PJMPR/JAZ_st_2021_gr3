package com.example.lab06.repository;

import com.example.lab06.parameters.Credit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Integer> {
}
