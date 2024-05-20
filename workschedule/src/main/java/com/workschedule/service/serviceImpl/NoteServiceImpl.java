package com.workschedule.service.serviceImpl;

import com.workschedule.Exception.ResourceNotFoundException;
import com.workschedule.model.Comment;
import com.workschedule.model.Note;
import com.workschedule.repository.NoteRepository;
import com.workschedule.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

@Autowired
private NoteRepository noteRepository;
    List<Note> noteList;
    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    @Override
    public Note findById(Long id) {
        if (noteRepository.findById(id) != null) {
            Note comment = noteRepository.findById(id).get();
            return comment;
        } else {
            throw new ResourceNotFoundException("Cannot find note with id:"+id);
        }
    }

    @Override
    public void deteleById(Long id) {
        noteRepository.deleteById(id);
    }

    @Override
    public Note save(Note role) {
        return noteRepository.save(role);
    }

    @Override
    public Note update(Note role) {
        return null;
    }
}
