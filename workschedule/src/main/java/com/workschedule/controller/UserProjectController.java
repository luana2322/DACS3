package com.workschedule.controller;

import com.workschedule.model.Project;
import com.workschedule.model.ProjectStatus;
import com.workschedule.model.User_Project;
import com.workschedule.service.serviceImpl.UserProjectServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserProjectController {
@Autowired
    private UserProjectServiceimpl userProjectServiceimpl;

    @PostMapping("/joinproject")
    public ResponseEntity<User_Project> addproject(@RequestParam("projectId") Long projectId
            , @RequestParam("userId") Long userId) {

     User_Project user_project=  userProjectServiceimpl.save(projectId,userId);
            user_project.getProject().setUserProjectList(null);
            user_project.getUsers().setUserTaskList(null);
            user_project.getUsers().setUserNotes(null);
            user_project.getUsers().setCommentList(null);
            user_project.getUsers().setUserProjectList(null);
        return ResponseEntity.ok(user_project);
    }

}
