package az.azer.springsecsection2.repository;

import az.azer.springsecsection2.model.ContactMessage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactMessageRepository extends CrudRepository<ContactMessage,String> {
    ContactMessage findByContactId(String contactId);

}
