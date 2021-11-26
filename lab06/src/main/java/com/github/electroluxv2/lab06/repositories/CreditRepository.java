package com.github.electroluxv2.lab06.repositories;

import com.github.electroluxv2.lab06.entities.Credit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditRepository extends CrudRepository<Credit, Long> {
    Credit findById(long id);
    @Query(value = "SELECT nextval(pg_get_serial_sequence('credits', 'id')) as new_id", nativeQuery = true)
    Long getNextId();
}
