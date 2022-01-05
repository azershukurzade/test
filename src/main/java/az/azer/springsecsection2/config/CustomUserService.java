package az.azer.springsecsection2.config;

import az.azer.springsecsection2.model.Authority;
import az.azer.springsecsection2.model.Customer;
import az.azer.springsecsection2.model.SecurityCustomer;
import az.azer.springsecsection2.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.sql.DataSource;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsManager {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("*** CustomUserService -> loadUserByUsername is called");
        List<Customer> customerList = customerRepository.findByEmail(username);
        if(CollectionUtils.isEmpty(customerList)) {
            throw new UsernameNotFoundException("User details not found for the user: " + username);
        }
        return new SecurityCustomer(customerList.get(0));
    }

    @Override
    public void createUser(UserDetails user) {
        SecurityCustomer securityCustomer = (SecurityCustomer) user;
        System.out.println("*** CustomUserService -> createUser is called");
        Customer customer = securityCustomer.getCustomer();
        //customer.setEmail(user.getUsername());
        customer.setPwd(passwordEncoder.encode(user.getPassword()));
    //    customer.setAuthorities((List<Authority>) user.getAuthorities());
        //customer.setRole(user.getAuthorities().stream().findFirst().get().getAuthority());
        customerRepository.save(customer);
    }

    @Override
    public void updateUser(UserDetails user) {
    }

    @Override
    public void deleteUser(String username) {
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {
    }

    @Override
    public boolean userExists(String username) {
        return false;
    }
}
