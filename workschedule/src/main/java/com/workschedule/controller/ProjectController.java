package com.workschedule.controller;

import com.workschedule.model.Project;
import com.workschedule.model.Role;
import com.workschedule.model.Task;
import com.workschedule.repository.ProjectRepository;
import com.workschedule.service.serviceImpl.ProjectServiceImpl;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping("/addproject")
    public ResponseEntity<Project> addproject(@RequestBody Project project) {
        return ResponseEntity.ok(projectServiceImpl.save(project));
    }

    @GetMapping("/searchproject")
    public ResponseEntity<List<Project>> searchproject(@RequestParam("data") String data) {
        return ResponseEntity.ok(projectRepository.searchproject(data));
    }
    @GetMapping("/getallproject")
    public ResponseEntity<List<Project>> getallproject() {
        return ResponseEntity.ok(projectServiceImpl.findAll());
    }

    @GetMapping("/deleteproject")
    public ResponseEntity<Void> deleteproject(@RequestParam("projectid") Long projectid) {
        projectServiceImpl.deteleById(projectid);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getprjectbymanageid")
    public ResponseEntity<List<Project>> gettaskbyprojectid(@RequestParam("projectid") Long manageId) {

        return ResponseEntity.ok(projectRepository.findProjectByManage(manageId));
    }

}
