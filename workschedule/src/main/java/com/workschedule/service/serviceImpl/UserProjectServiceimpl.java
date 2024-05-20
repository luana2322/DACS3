package com.workschedule.service.serviceImpl;

import com.workschedule.model.Task;
import com.workschedule.model.User_Project;
import com.workschedule.repository.UserProjectRepository;
import com.workschedule.service.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserProjectServiceimpl implements UserProjectService {
    @Autowired
    private UserProjectRepository userProjectRepository;


    @Override
    public List<User_Project> findAll() {
        return null;
    }

    @Override
    public User_Project findById(Long id) {
        return null;
    }

    @Override
    public void deteleById(Long id) {

    }

    @Override
    public User_Project save(User_Project userProject) {
        return userProjectRepository.save(userProject);
    }

    @Override
    public User_Project update(User_Project userProject) {
        return null;
    }
}
