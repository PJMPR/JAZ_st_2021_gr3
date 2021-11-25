package com.github.electroluxv2.lab06.service;

import com.github.electroluxv2.lab06.entity.Credit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Long> {
    Credit findById(long id);
}
