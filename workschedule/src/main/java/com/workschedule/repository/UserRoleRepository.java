package com.workschedule.repository;
import com.workschedule.model.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRoleRepository extends JpaRepository<User_Role, Long> {
}