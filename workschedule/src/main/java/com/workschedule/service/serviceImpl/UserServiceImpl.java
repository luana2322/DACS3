package com.workschedule.service.serviceImpl;

import com.workschedule.model.Users;
import com.workschedule.service.UserRoleService;
import com.workschedule.service.UsersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService {


    @Override
    public List<Users> findAll() {
        return null;
    }

    @Override
    public Users findById(Long id) {
        return null;
    }

    @Override
    public void deteleById(Long id) {
    }

    @Override
    public Users save(Users users) {
        return null;
    }

    @Override
    public Users update(Users users) {
        return null;
    }
}
