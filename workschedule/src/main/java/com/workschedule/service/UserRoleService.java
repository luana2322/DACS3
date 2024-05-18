package com.workschedule.service;

import com.workschedule.model.User_Project;

import java.util.List;

public interface UserRoleService {
    List<User_Project> findAll();

    User_Project findById(Long id);

    void deteleById(Long id);

    User_Project save(User_Project userTask);

    User_Project update(User_Project userTask);
}
