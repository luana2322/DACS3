package com.workschedule.repository;

import com.workschedule.model.Conversation;
import com.workschedule.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
