package az.azer.springsecsection2.repository;

import az.azer.springsecsection2.model.AccountTransaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends CrudRepository<AccountTransaction, String> {
    List<AccountTransaction> findByCustomerIdOrderByTransactionDt(int customerId);
}
