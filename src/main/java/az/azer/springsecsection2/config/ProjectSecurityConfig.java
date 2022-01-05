package az.azer.springsecsection2.config;

import az.azer.springsecsection2.filter.AuthoritiesLoggingAfterFilter;
import az.azer.springsecsection2.filter.AuthoritiesLoggingAtFilter;
import az.azer.springsecsection2.filter.RequestValidationBeforeFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.util.Collections;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //Authenticate all
        /*http.authorizeRequests((requests) -> {
            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
        });
        http.formLogin();
        http.httpBasic();*/


        //Custom configuration
        http.cors().configurationSource(new CorsConfigurationSource() {
                    @Override
                    public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                        CorsConfiguration config = new CorsConfiguration();
                       config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                       /* config.setAllowedOriginPatterns(Collections.singletonList("*")); */
                        config.setAllowedMethods(Collections.singletonList("*"));
                        config.setAllowCredentials(true);
                        config.setAllowedHeaders(Collections.singletonList("*"));
                        config.setMaxAge(3600L);
                        return config;
                    }
                }).and().csrf().disable()
                .addFilterBefore(new RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthoritiesLoggingAfterFilter(),BasicAuthenticationFilter.class)
                .addFilterAt(new AuthoritiesLoggingAtFilter(), BasicAuthenticationFilter.class)
                /*ignoringAntMatchers("/contact")
                .ignoringAntMatchers("/save")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and()*/
                .authorizeRequests()
                .antMatchers("/myAccount")./*authenticated()*/ hasAuthority("WRITE")
                .antMatchers("/myBalance")./*authenticated()*/ hasAuthority("READ")
                .antMatchers("/myLoans")./*authenticated()*/ hasAuthority("DELETE")
                .antMatchers("/myCards")./*authenticated()*/hasRole("ADMIN")
                .antMatchers("/user").authenticated()
                .antMatchers("/notices").permitAll()
                .antMatchers("/contact").permitAll()
                .antMatchers("/save").permitAll()
                .and().httpBasic();


        //denyAll
        /*http.
                authorizeRequests().
               anyRequest().denyAll().
                and().
                formLogin().
                and().
                httpBasic();*/



        //permitAll
       /* http.
                authorizeRequests().
                anyRequest().permitAll().
                and().
                formLogin().
                and().
                httpBasic();*/
    }

  /*  @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //Version 1
        *//*auth.inMemoryAuthentication().withUser("admin").password("12345").authorities("admin").and()
                .withUser("user").password("12345").authorities("read").and()
                .passwordEncoder(NoOpPasswordEncoder.getInstance());*//*


        //Version 2
        *//*InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
        UserDetails user1 = User.withUsername("admin").password("12345").authorities("admin").build();
        UserDetails user2 = User.withUsername("user").password("12345").authorities("read").build();
        userDetailsService.createUser(user1);
        userDetailsService.createUser(user2);
        auth.userDetailsService(userDetailsService);*//*

    }*/

    /*@Bean
    public UserDetailsService userDetailService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }*/




    @Bean
    public PasswordEncoder passwordEncoder() {
        return //NoOpPasswordEncoder.getInstance()// ;
               //new  StandardPasswordEncoder();
        new BCryptPasswordEncoder();
    }




}
