package az.azer.springsecsection2.controller;

import az.azer.springsecsection2.model.AccountTransaction;
import az.azer.springsecsection2.model.Customer;
import az.azer.springsecsection2.repository.AccountTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BalanceController {
    @Autowired
    AccountTransactionRepository accountTransactionRepository;

    @PostMapping("/myBalance")
    public List<AccountTransaction> getBalanceDetails(@RequestBody Customer customer) {
        List<AccountTransaction> accountTransactions = accountTransactionRepository.
                findByCustomerIdOrderByTransactionDt(customer.getId());
        if (accountTransactions != null) {
            return accountTransactions;
        } else {
            return null;
        }
    }
}
