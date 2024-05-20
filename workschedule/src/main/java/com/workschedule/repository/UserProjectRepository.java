package com.workschedule.repository;

import com.workschedule.model.Project;
import com.workschedule.model.User_Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProjectRepository  extends JpaRepository<User_Project, Long> {
}
