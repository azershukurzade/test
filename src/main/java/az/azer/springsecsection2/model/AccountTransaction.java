package az.azer.springsecsection2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "account_transactions")
public class AccountTransaction {
    @Id
    private String transactionId;
    private int accountNumber;
    @Temporal(TemporalType.DATE)
    private Date transactionDt;
    private String transactionSummary;
    private String transactionType;
    private int transactionAmt;
    private int closingBalance;
    @Temporal(TemporalType.DATE)
    private Date createDt;
    private int customerId;

}
