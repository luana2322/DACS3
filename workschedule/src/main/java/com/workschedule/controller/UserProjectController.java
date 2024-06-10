package com.workschedule.controller;

import com.workschedule.model.Project;
import com.workschedule.model.ProjectStatus;
import com.workschedule.model.User_Project;
import com.workschedule.service.serviceImpl.UserProjectServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserProjectController {
@Autowired
    private UserProjectServiceimpl userProjectServiceimpl;

    @PostMapping("/joinproject")
    public ResponseEntity<User_Project> addproject(@RequestParam("projectId") String projectId
            , @RequestParam("userId") Long userId) {

        User_Project user_project=  userProjectServiceimpl.save(projectId,userId);
        user_project.getProject().setUserProjectList(null);
        user_project.getUsers().setUserTaskList(null);
        user_project.getUsers().setUserNotes(null);
        user_project.getUsers().setCommentList(null);
        user_project.getUsers().setUserProjectList(null);
        return ResponseEntity.ok(user_project);
    }

    @PostMapping("/updateuserproject")
    public ResponseEntity<User_Project> updateuserproject(@RequestParam("projectId") String projectId
            , @RequestParam("userId") Long userId
            // , @RequestParam("userProjectId") Long userProjectId     khi nào cần dùng dùng lại đỡ quên và khả năng là ko bao giờ
            , @RequestParam("roleId") Long roleId ) {

        User_Project user_project=  userProjectServiceimpl.update(projectId,userId,roleId);
        user_project.getProject().setUserProjectList(null);
        user_project.getUsers().setUserTaskList(null);
        user_project.getUsers().setUserNotes(null);
        user_project.getUsers().setCommentList(null);
        user_project.getUsers().setUserProjectList(null);
        return ResponseEntity.ok(user_project);
    }

    @GetMapping("/findAlluspr")
    public ResponseEntity<List<User_Project>> findAlluspr( ) {
        List<User_Project> userProjectList=userProjectServiceimpl.findAll();
        for(User_Project userProject:userProjectList){
            userProject.getProject().setUserProjectList(null);
            userProject.getUsers().setUserProjectList(null);
            userProject.getUsers().setUserTaskList(null);
            userProject.getUsers().setUserNotes(null);
            userProject.getUsers().setCommentList(null);
        }
        return ResponseEntity.ok(userProjectList);
    }


}
