package az.azer.springsecsection2.repository;

import az.azer.springsecsection2.model.Card;
import az.azer.springsecsection2.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CardRepository extends CrudRepository<Card, Integer> {
    List<Card> findByCustomerId(int customerId);
}
