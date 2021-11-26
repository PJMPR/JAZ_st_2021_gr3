package pjatk.pl.lab06.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pjatk.pl.lab06.Loan.Installment;

@Repository
public interface InstallmentRepo extends CrudRepository<Installment, Long> {
    public Installment findById(long id);
}
