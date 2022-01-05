package az.azer.springsecsection2.controller;

import az.azer.springsecsection2.model.NoticeDetail;
import az.azer.springsecsection2.repository.NoticeDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoticesController {
    @Autowired
    NoticeDetailsRepository noticeDetailsRepository;
    @GetMapping("/notices")
    public List<NoticeDetail> getNotices() {

        List<NoticeDetail> noticeDetails = noticeDetailsRepository.findAllActiveNotices();
        return noticeDetails;
    }
}
