package az.azer.springsecsection2.repository;

import az.azer.springsecsection2.model.NoticeDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoticeDetailsRepository extends CrudRepository<NoticeDetail,Integer> {
    @Query(nativeQuery = true,
            value = "select * from notice_details t /*where CURDATE() between t.notic_beg_dt and t.notic_end_dt*/")
    List<NoticeDetail> findAllActiveNotices();
}
