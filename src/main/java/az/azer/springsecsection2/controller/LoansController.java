package az.azer.springsecsection2.controller;

import az.azer.springsecsection2.model.Customer;
import az.azer.springsecsection2.model.Loan;
import az.azer.springsecsection2.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoansController {
    @Autowired
    LoanRepository loanRepository;

    @PostMapping("/myLoans")
    public List<Loan> getLoanDetails(@RequestBody Customer customer) {
        List<Loan> loans = loanRepository.findByCustomerIdOrderByStartDtDesc(customer.getId());
        if (loans != null) {
            return loans;
        } else {
            return null;
        }
    }
}
