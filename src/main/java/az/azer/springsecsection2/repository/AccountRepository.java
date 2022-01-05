package az.azer.springsecsection2.repository;

import az.azer.springsecsection2.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountRepository extends CrudRepository<Account,Integer> {
    List<Account> findAllByCustomerId(int customerId);
}
