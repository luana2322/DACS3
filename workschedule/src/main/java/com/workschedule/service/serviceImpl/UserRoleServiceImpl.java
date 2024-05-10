package com.workschedule.service.serviceImpl;

import com.workschedule.model.User_Role;
import com.workschedule.repository.UserRoleRepository;
import com.workschedule.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleRepository userRoleRepository;
    List<User_Role> userRoleList;



    @Override
    public List<User_Role> findAll() {
        this.userRoleList = this.userRoleRepository.findAll();
        return this.userRoleList;
    }

    @Override
    public User_Role findById(Long id) {
        if (this.userRoleRepository.existsById(id)) {
            User_Role userRole = (User_Role)this.userRoleRepository.findById(id).get();
            return userRole;
        } else {
            return null;
        }
    }

    @Override
    public void deteleById(Long id) {
    }

    @Override
    public User_Role save(User_Role userTask) {
        return null;
    }

    @Override
    public User_Role update(User_Role userTask) {
        return null;
    }
}
