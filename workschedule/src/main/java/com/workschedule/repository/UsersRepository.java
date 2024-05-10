package com.workschedule.repository;

import java.util.Optional;

import com.workschedule.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByemail(String email);
}
