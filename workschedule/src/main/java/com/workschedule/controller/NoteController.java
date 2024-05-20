package com.workschedule.controller;

import com.workschedule.model.Comment;
import com.workschedule.model.Note;
import com.workschedule.service.serviceImpl.NoteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {
    @Autowired
    private NoteServiceImpl noteServiceImpl;


    @PostMapping("/addnote")
    public ResponseEntity<Note> addnote(@RequestBody Note note) {
        return ResponseEntity.ok(noteServiceImpl.save(note));
    }


    @GetMapping("/getallnote")
    public ResponseEntity<List<Note>> getallnote() {
        return ResponseEntity.ok(noteServiceImpl.findAll());
    }

    @GetMapping("/deletenote")
    public ResponseEntity<Void> deletenote(@RequestParam("noteId") Long noteId) {
        noteServiceImpl.deteleById(noteId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getnotebyid")
    public ResponseEntity<Note> findbyid(@RequestParam("noteId") Long noteId) {

        return ResponseEntity.ok(noteServiceImpl.findById(noteId));
    }
}
