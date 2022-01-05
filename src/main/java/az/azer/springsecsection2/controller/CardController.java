package az.azer.springsecsection2.controller;

import az.azer.springsecsection2.model.Card;
import az.azer.springsecsection2.model.Customer;
import az.azer.springsecsection2.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CardController {
    @Autowired
    CardRepository cardRepository;

    @PostMapping("/myCards")
    public List<Card> getCardDetails(@RequestBody Customer customer) {
        List<Card> cards = cardRepository.findByCustomerId(customer.getId());
        if (cards != null) {
            return cards;
        } else {
            return null;
        }
    }
}
