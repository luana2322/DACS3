package com.workschedule.service.serviceImpl;

import com.workschedule.Exception.ResourceNotFoundException;
import com.workschedule.model.Task;
import com.workschedule.repository.TaskRepository;
import com.workschedule.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;
    List<Task> taskList;



    @Override
    public List<Task> findAll() {
        this.taskList = this.taskRepository.findAll();
        for(Task task:taskList){
            task.setUserTaskList(null);
            task.setCommentList(null);
        }
        return this.taskList;
    }

    @Override
    public Task findById(Long id) {
        if (this.taskRepository.existsById(id)) {
            Task task = (Task)this.taskRepository.findById(id).get();
           task.setUserTaskList(null);
           task.setCommentList(null);
            return task;
        } else {
            throw new ResourceNotFoundException("Cannot find task with id:"+id);
        }
    }

    @Override
    public void deteleById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task save(Task task) {
        Task task1=taskRepository.save(task);
         task1.setCommentList(null);
        task1.setUserTaskList(null);

         return task1;
    }

    @Override
    public Task update(Task task) {
        return null;
    }
}
