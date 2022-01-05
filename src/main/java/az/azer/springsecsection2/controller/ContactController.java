package az.azer.springsecsection2.controller;

import az.azer.springsecsection2.model.ContactMessage;
import az.azer.springsecsection2.repository.ContactMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.Random;

@RestController
public class ContactController {
    @Autowired
    private ContactMessageRepository contactMessageRepository;

    @PostMapping("/contact")
    public ContactMessage saveContactInquiryDetails(@RequestBody ContactMessage contactMessage) {
        contactMessage.setContactId(getServiceReqNumber());
        contactMessage.setCreateDt(new Date(System.currentTimeMillis()));
        return contactMessageRepository.save(contactMessage);
    }

    public String getServiceReqNumber() {
        Random random = new Random();
        int ranNum = random.nextInt(999999999 - 9999) + 9999;
        return "SR"+ranNum;
    }

}
