package com.github.electroluxv2.lab06.repositories;

import com.github.electroluxv2.lab06.entities.Credit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Long> {
    Credit findById(long id);
}
