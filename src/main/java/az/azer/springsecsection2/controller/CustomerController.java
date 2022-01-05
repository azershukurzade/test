package az.azer.springsecsection2.controller;

import az.azer.springsecsection2.model.Customer;
import az.azer.springsecsection2.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
   @Autowired
    CustomerService customerService;

    @PostMapping("/save")
    int saveCustomer(@RequestBody Customer customer) {
        System.out.println("*** CustomerController -> saveCustomer is called");
        return customerService.save(customer);

    }

}
