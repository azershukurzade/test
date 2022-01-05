package az.azer.springsecsection2.repository;

import az.azer.springsecsection2.model.Loan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanRepository extends CrudRepository<Loan,Integer> {
    List<Loan> findByCustomerIdOrderByStartDtDesc(int customerId);
}
