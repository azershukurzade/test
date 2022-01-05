package az.azer.springsecsection2.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class NoticeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noticeId;
    private String noticeSummary;
    private String noticeDetails;
    @Temporal(TemporalType.DATE)
    private Date noticBegDt;
    @Temporal(TemporalType.DATE)
    private Date noticEndDt;
    @Temporal(TemporalType.DATE)
    private Date createDt;
    @Temporal(TemporalType.DATE)
    private Date updateDt;
}
