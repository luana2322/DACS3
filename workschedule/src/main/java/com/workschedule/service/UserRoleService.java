package com.workschedule.service;

import com.workschedule.model.User_Role;

import java.util.List;

public interface UserRoleService {
    List<User_Role> findAll();

    User_Role findById(Long id);

    void deteleById(Long id);

    User_Role save(User_Role userTask);

    User_Role update(User_Role userTask);
}
