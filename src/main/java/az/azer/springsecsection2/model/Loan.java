package az.azer.springsecsection2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "loans")
public class Loan {
    @Id
    @Column(name = "loan_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loanNumber;
    @Temporal(TemporalType.DATE)
    private Date startDt;
    private String loanType;
    private int totalLoan;
    private int amountPaid;
    private int outstandingAmount;
    @Temporal(TemporalType.DATE)
    private Date createDt;
    private int customerId;
}
