package com.workschedule.service;

import com.workschedule.model.Task;
import com.workschedule.model.User_Project;

import java.util.List;

public interface UserProjectService {

    List<User_Project> findAll();

    User_Project findById(Long id);


    void deteleById(Long id);

    User_Project save(Long projectId,Long userId);

    User_Project saveowner(User_Project userProject);

    User_Project update(User_Project task);

}
