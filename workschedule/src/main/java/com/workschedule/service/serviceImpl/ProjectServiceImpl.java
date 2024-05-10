package com.workschedule.service.serviceImpl;

import com.workschedule.model.Project;
import com.workschedule.repository.ProjectRepository;
import com.workschedule.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    List<Project> projectList;



    @Override
    public List<Project> findAll() {
        this.projectList = this.projectRepository.findAll();
        return this.projectList;
    }

    @Override
    public Project findById(Long id) {
        if (this.projectRepository.existsById(id)) {
            Project project = (Project)this.projectRepository.findById(id).get();
            return project;
        } else {
            return null;
        }
    }

    @Override
    public void deteleById(Long id) {
    }

    @Override
    public Project save(Project project) {
        return null;
    }

    @Override
    public Project update(Project project) {
        return null;
    }
}
