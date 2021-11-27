package Lab06.Repository;

import Lab06.Credit.Credit;
import org.springframework.data.repository.CrudRepository;


public interface CreditRepository extends CrudRepository<Credit, Integer> {

}
