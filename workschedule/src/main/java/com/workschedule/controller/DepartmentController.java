package com.workschedule.controller;

import com.workschedule.model.Conversation;
import com.workschedule.model.Department;
import com.workschedule.service.serviceImpl.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
@Autowired
private DepartmentServiceImpl departmentServiceImpl;


    @PostMapping("/adddepartment")
    public ResponseEntity<Department> addconversation(@RequestBody Department department) {
        return ResponseEntity.ok(departmentServiceImpl.save(department));
    }


    @GetMapping("/getalldepartment")
    public ResponseEntity<List<Department>> getallconversation() {
        return ResponseEntity.ok(departmentServiceImpl.findAll());
    }

    @GetMapping("/deletedepartment")
    public ResponseEntity<Void> deleteconversation(@RequestParam("departmentid") Long departmentid) {
        departmentServiceImpl.deteleById(departmentid);
        return ResponseEntity.ok().build();
    }

}
