package com.github.electroluxv2.lab06.service;

import com.github.electroluxv2.lab06.entity.Installment;
import com.github.electroluxv2.lab06.entity.InstallmentId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstallmentRepository extends CrudRepository<Installment, InstallmentId> {
    List<Installment> findAllByCreditId(long id);
}
