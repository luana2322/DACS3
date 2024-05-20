package com.workschedule.repository;
import com.workschedule.model.Project;
import com.workschedule.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    @Query(value="select a.*,c.project_name\r\n"
            + "			from project c \r\n"
            + "			join task a \r\n"
            + "			on a.project_id=c.project_id\r\n"

            + "         where c.project_id=?1 ",nativeQuery = true)
    List<Task> findTaskByProject(Long project_id);
}
