package com.workschedule.controller;

import com.workschedule.Exception.ResourceNotFoundException;
import com.workschedule.model.Note;
import com.workschedule.model.Project;
import com.workschedule.model.Task;
import com.workschedule.model.TaskStatus;
import com.workschedule.repository.TaskRepository;
import com.workschedule.service.serviceImpl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class TaskController {
@Autowired
    private TaskServiceImpl taskServiceImpl;
@Autowired
private TaskRepository taskRepository;


    @PostMapping("/addtask")
    public ResponseEntity<Task> addconversation(@RequestBody Task task) {
       task.setTaskStatus(TaskStatus.TODO.toString());
        return ResponseEntity.ok(taskServiceImpl.save(task));
    }


    @GetMapping("/getalltask")
    public ResponseEntity<List<Task>> getallconversation() {
        return ResponseEntity.ok(taskServiceImpl.findAll());
    }

    @GetMapping("/deletetask")
    public ResponseEntity<Void> deleteconversation(@RequestParam("taskid") Long taskid) {
        taskServiceImpl.deteleById(taskid);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/gettaskbyprojectid")
    public ResponseEntity<List<Task>> gettaskbyprojectid(@RequestParam("projectid") Long projectid) {
        taskServiceImpl.deteleById(projectid);
        return ResponseEntity.ok(taskRepository.findTaskByProject(projectid));
    }

    @GetMapping("/getalltaskbyuser")
    public ResponseEntity<List<Task>> getalltaskbyuser(@RequestParam("userId") Long userId) {

        List<Task> taskList= taskRepository.findTaskbyUser(userId);

        for (Task note:taskList){
            note.setUserTaskList(null);
        }

        return ResponseEntity.ok(taskList);


        }

    @GetMapping("/findtaskbydate")
    public ResponseEntity<List<Task>> findprojectbydate(@RequestParam("user_id") Long user_id
            , @RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Task> project = taskRepository.findTaskbydate(user_id, date);
        if (project != null) {
            List<Task> taskList=  taskRepository.findTaskbydate(user_id, date);

            for (Task note:taskList){
                note.setUserTaskList(null);
            }

            return ResponseEntity.ok(taskList);

        } else {
            throw new ResourceNotFoundException("Hôm nay rảnh.Không có việc");
        }

    }



}
