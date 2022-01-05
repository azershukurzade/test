package az.azer.springsecsection2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    private int accountNumber;
    private String accountType;
    private String branchAddress;
    @Temporal(TemporalType.DATE)
    private Date createDt;
    private int customerId;
}
