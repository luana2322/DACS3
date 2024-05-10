package com.workschedule.service;

import com.workschedule.model.Users;

import java.util.List;

public interface UsersService {
    List<Users> findAll();

    Users findById(Long id);

    void deteleById(Long id);

    Users save(Users users);

    Users update(Users users);
}
