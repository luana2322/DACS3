package com.workschedule.controller;

import com.workschedule.model.Comment;
import com.workschedule.model.Project;
import com.workschedule.service.serviceImpl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentServiceImpl commentServiceImpl;


    @PostMapping("/addcomment")
    public ResponseEntity<Comment> addcomment(@RequestBody Comment comment) {
        return ResponseEntity.ok(commentServiceImpl.save(comment));
    }


    @GetMapping("/getallcomment")
    public ResponseEntity<List<Comment>> getallcomment() {
        return ResponseEntity.ok(commentServiceImpl.findAll());
    }

    @GetMapping("/deletecomment")
    public ResponseEntity<Void> deletecomment(@RequestParam("commentId") Long commentId) {
        commentServiceImpl.deteleById(commentId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getcommentbyid")
    public ResponseEntity<Comment> findbyid(@RequestParam("commentId") Long commentId) {

        return ResponseEntity.ok(commentServiceImpl.findById(commentId));
    }


}
