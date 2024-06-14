package com.workschedule.repository;
import com.workschedule.model.Message;
import com.workschedule.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    @Query(value="select m.type,m.receiverName,m.message_id,m.message,m.date,m.senderName,m.user_project_id " +
            " from project p\n" +
            "join user_project up\n" +
            "on up.project_id=p.project_id\n" +
            "join message m\n" +
            "on up.user_project_id=m.user_project_id\n" +
            "where m.user_project_id=?1\n" +
            "group by m.message_id;\n",nativeQuery = true)
    List<Message> getallmessage(Long userId);
}
