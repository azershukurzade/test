package az.azer.springsecsection2;

import az.azer.springsecsection2.repository.ContactMessageRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Springsecsection2ApplicationTests {
	@Autowired
	ContactMessageRepository contactMessageRepository;

	@Test
	void contextLoads() {
	}

	@Test
	@Disabled
	void findByContactId() {
		System.out.println("***** findByContactId *****");
	//	System.out.println(contactMessageRepository.findByContactId(1));
	}

	@Test
	@Disabled
	void findById() {
		System.out.println("***** findById *****");
		//System.out.println(contactMessageRepository.findByContactId(1));
	}

}
