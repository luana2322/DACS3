package com.workschedule.service;

import com.workschedule.dto.UserDto;
import com.workschedule.model.Users;

import java.util.List;

public interface UsersService {
    List<Users> findAll();

    Users findById(Long id);

    void deteleById(Long id);


    Users save(UserDto userDto);

    Users update(Users users);

    boolean login(UserDto userDto);

}
