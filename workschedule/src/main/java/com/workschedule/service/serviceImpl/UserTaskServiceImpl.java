package com.workschedule.service.serviceImpl;

import com.workschedule.Exception.ResourceNotFoundException;
import com.workschedule.model.Note;
import com.workschedule.model.User_Task;
import com.workschedule.model.Users;
import com.workschedule.repository.UserTaskRepository;
import com.workschedule.service.UserTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTaskServiceImpl implements UserTaskService {
@Autowired
private UserTaskRepository userTaskRepository;

    @Override
    public List<User_Task> findAll() {
        return userTaskRepository.findAll();
    }

    @Override
    public User_Task findById(Long id) {
        if (userTaskRepository.findById(id) != null) {
            User_Task userTask = userTaskRepository.findById(id).get();
            return userTask;
        } else {
            throw new ResourceNotFoundException("Cannot find userTask with id:"+id);
        }
    }

    @Override
    public void deteleById(Long id) {
        userTaskRepository.deleteById(id);
    }

    @Override
    public User_Task save(User_Task userTask) {
        return userTaskRepository.save(userTask);
    }

    @Override
    public User_Task update(User_Task userTask) {
        return null;
    }
}
