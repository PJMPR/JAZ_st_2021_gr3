package jaz.lab06.demo.service;

import jaz.lab06.demo.credit.Credit;
import org.springframework.data.repository.CrudRepository;

public interface CreditDataRepository extends CrudRepository<Credit, Integer> {
    Credit findById(int id);
}