package az.azer.springsecsection2.controller;

import az.azer.springsecsection2.model.Account;
import az.azer.springsecsection2.model.Customer;
import az.azer.springsecsection2.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    AccountRepository accountRepository;

    @PostMapping("/myAccount")
    public List<Account> getAccountDetails(@RequestBody Customer customer) {
        List<Account> accounts = accountRepository.findAllByCustomerId(customer.getId());
        if (accounts != null) {
            return accounts;
        } else {
            return null;
        }
    }
}
