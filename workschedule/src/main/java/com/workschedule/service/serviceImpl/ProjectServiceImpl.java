package com.workschedule.service.serviceImpl;

import com.workschedule.Exception.ResourceNotFoundException;
import com.workschedule.RandomCode.SecureRandomStringGenerator;
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
        projectList = this.projectRepository.findAll();
        return projectList;
    }

    @Override
    public Project findById(Long id) {
        if (this.projectRepository.existsById(id)) {
            Project project = (Project)this.projectRepository.findById(id).get();
            return project;
        } else {
            throw new ResourceNotFoundException("Cannot find project with id:"+id);
        }
    }

    @Override
    public void deteleById(Long id) {
    projectRepository.deleteById(id);
    }

    @Override
    public Project save(Project project) {
        SecureRandomStringGenerator secureRandomStringGenerator=new SecureRandomStringGenerator();
        int length = 10; // Độ dài của chuỗi ngẫu nhiên
        String randomString = secureRandomStringGenerator.generateSecureRandomString(length);
        System.out.println("Chuỗi ngẫu nhiên bảo mật: " + randomString);

        project.setProject_id(randomString);
project.setUserProjectList(null);
        return projectRepository.save(project);
    }

    @Override
    public Project update(Project project,Long id) {
        Project pro=findById(id);
        pro.setProjectName(project.getProjectName());
        pro.setProjectStatus(project.getProjectStatus());
        pro.setProjectDescription(project.getProjectDescription());
        pro.setTimeStart(project.getTimeStart());
        pro.setTimeEnd(project.getTimeEnd());
        pro.setProjectowner(project.getProjectowner());

        Project prosaved=projectRepository.save(pro);
        prosaved.setUserProjectList(null);
        return prosaved;
    }
}
