package com.workschedule.service.serviceImpl;

import com.workschedule.Exception.ResourceNotFoundException;
import com.workschedule.model.Project;
import com.workschedule.model.Task;
import com.workschedule.model.User_Project;
import com.workschedule.repository.ProjectRepository;
import com.workschedule.repository.UserProjectRepository;
import com.workschedule.repository.UsersRepository;
import com.workschedule.service.UserProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserProjectServiceimpl implements UserProjectService {
    @Autowired
    private UserProjectRepository userProjectRepository;
    @Autowired
    private ProjectRepository  projectRepository;
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private ProjectServiceImpl projectServiceImpl;
    @Override
    public List<User_Project> findAll() {
        return userProjectRepository.findAll();
    }

    @Override
    public User_Project findById(Long id) {
        if (userProjectRepository.existsById(id)) {
            User_Project project = userProjectRepository.findById(id).get();
            return project;
        } else {
            throw new ResourceNotFoundException("Cannot find userProject with id:"+id);
        }
    }

    @Override
    public void deteleById(Long id) {
        if (userProjectRepository.existsById(id)) {
           userProjectRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Cannot find userProject with id:"+id);
        }
    }

    @Override
    public User_Project save(Long projectId,Long userId) {
        if (!projectRepository.existsById(projectId)) {
            throw new ResourceNotFoundException("Cannot find Project with id:"+projectId);
        } else if(!usersRepository.existsById(userId)) {
            throw new ResourceNotFoundException("Cannot find Project with id:"+userId);
        }else{
            User_Project userProject=User_Project.builder()
                    .users(userServiceImpl.findById(userId))
                    .project(projectServiceImpl.findById(projectId))
                    .build();
            return userProjectRepository.save(userProject);
        }


    }

    @Override
    public User_Project saveowner(User_Project userProject) {
    return   userProjectRepository.save(userProject);
    }


    @Override
    public User_Project update(User_Project userProject) {
        return null;
    }
}
