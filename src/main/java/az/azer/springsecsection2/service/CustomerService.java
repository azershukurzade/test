package az.azer.springsecsection2.service;

import az.azer.springsecsection2.config.CustomUserService;
import az.azer.springsecsection2.model.Authority;
import az.azer.springsecsection2.model.Customer;
import az.azer.springsecsection2.model.SecurityCustomer;
import az.azer.springsecsection2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerService {
    @Autowired
    CustomUserService customUserService;
    @Autowired
    CustomerRepository customerRepository;

    public int save(Customer customer) {
        System.out.println("*** CustomerService -> save is called");
        customer.getAuthorities().forEach(authority -> authority.setCustomer(customer));
        SecurityCustomer securityCustomer = new SecurityCustomer(customer);
        /*UserDetails user1 = User.withUsername(customer.getEmail()).password(customer.getPwd()).build();
        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) user1.getAuthorities();
        for (Authority authority : customer.getAuthorities()) {
            authorities.add(new SimpleGrantedAuthority(authority.getName()));
        }*/

        customUserService.createUser(securityCustomer);
        return customerRepository.findByEmail(customer.getEmail()).get(0).getId();
    }
}
