package com.workschedule.repository;
import com.workschedule.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query(value="select a.*,c.taskName\r\n"
            + "			from project a \r\n"
            + "			join task c \r\n"
            + "			on a.project_id=c.project_id\r\n"

            + "         where lower(a.project_name) like lower(concat('%',:keyword,'%'))\r\n"
            + "         and lower(a.projectDescription) like lower(concat('%',:keyword,'%'))\r\n"
            + "         or lower(c.taskName) like lower(concat('%',:keyword,'%'))\r\n"
            + "         or lower(c.taskStatus) like lower(concat('%',:keyword,'%'))\r\n"
            + "           \r\n"
            + "         group by a.project_id ",nativeQuery = true)
    List<Project> searchproject(String keyword);
}
