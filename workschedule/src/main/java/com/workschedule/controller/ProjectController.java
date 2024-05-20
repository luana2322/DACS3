package com.workschedule.controller;

import com.workschedule.Exception.ResourceNotFoundException;
import com.workschedule.model.Project;
import com.workschedule.model.Role;
import com.workschedule.model.Task;
import com.workschedule.model.User_Project;
import com.workschedule.repository.ProjectRepository;
import com.workschedule.service.serviceImpl.ProjectServiceImpl;
import com.workschedule.service.serviceImpl.UserProjectServiceimpl;
import com.workschedule.service.serviceImpl.UserServiceImpl;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
public class ProjectController {

    @Autowired
    private ProjectServiceImpl projectServiceImpl;

    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserProjectServiceimpl userProjectServiceimpl;
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/createdproject")
    public ResponseEntity<Project> addproject(@RequestBody Project project
            , @RequestParam("userId") Long userId) {
        Project projectsaved = projectServiceImpl.save(project);

        User_Project userProject = new User_Project();
        userProject.setProject(projectsaved);
        userProject.setUsers(userService.findById(userId));
        userProjectServiceimpl.save(userProject);

        return ResponseEntity.ok(projectsaved);
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

    @GetMapping("/findprojectbydate")
    public ResponseEntity<List<Project>> findprojectbydate(@RequestParam("user_id") Long user_id
            , @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Project> project = projectRepository.findProjectdate(user_id, date);
        if (project != null) {
                for (Project pro:project ){
                  //  pro.setUserProjectList(null);
                }
            return ResponseEntity.ok(project);
        } else {
            throw new ResourceNotFoundException("Hôm nay rảnh");
        }

    }


}
