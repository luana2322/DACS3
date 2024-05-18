package com.workschedule.repository;

import com.workschedule.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CommentRepository extends JpaRepository<Comment, Long> {
}
