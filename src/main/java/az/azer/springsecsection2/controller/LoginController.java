package az.azer.springsecsection2.controller;

import az.azer.springsecsection2.model.Customer;
import az.azer.springsecsection2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/user")
    public Customer getUserDetailsAfterLogin(Principal user) {
        System.out.println("*****");
        List<Customer> customers = customerRepository.findByEmail(user.getName());
        if (customers.size() > 0) {
            return customers.get(0);
        }else {
            return null;
        }

    }
}
