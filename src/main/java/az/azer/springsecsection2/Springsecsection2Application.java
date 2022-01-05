package az.azer.springsecsection2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class Springsecsection2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springsecsection2Application.class, args);
	}

}
