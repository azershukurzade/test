package az.azer.springsecsection2.config;

import az.azer.springsecsection2.model.Customer;
import az.azer.springsecsection2.repository.CustomerRepository;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

// Custom Authentication Provider by me
@Component
public class CustomAuthenticationProvider  implements AuthenticationProvider {
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("CustomAuthenticationProvider -> authenticate is called");
        String usernameFromRequest = authentication.getName();
        String passwordFromRequest = String.valueOf(authentication.getCredentials());
        Customer customer = customerRepository.findByEmail(usernameFromRequest).get(0);
        if(customer == null) {
            throw new BadCredentialsException("No user registered with this details!");
        }

        if(passwordEncoder.matches(passwordFromRequest,customer.getPwd())) {
            List<GrantedAuthority> authorities = new ArrayList<>();
            /*authorities.add(
              new SimpleGrantedAuthority(customer.getRole())
            );*/

            customer.getAuthorities().forEach(authority -> authorities.add(new SimpleGrantedAuthority(authority.getName())));
            return new UsernamePasswordAuthenticationToken(usernameFromRequest,passwordFromRequest,authorities);
        }else {
            throw new BadCredentialsException("Invalid password");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        System.out.println("CustomAuthenticationProvider -> supports is called");
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
