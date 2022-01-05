package az.azer.springsecsection2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "contact_messages")
public class ContactMessage {
    @Id
    private String contactId;
    private String contactName;
    private String contactEmail;
    private String subject;
    private String message;
    @Temporal(TemporalType.DATE)
    private Date createDt;
}
