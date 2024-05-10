package com.workschedule.service.serviceImpl;

import com.workschedule.model.Department;
import com.workschedule.repository.DepartmentRepository;
import com.workschedule.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    List<Department> departmentList;


    @Override
    public List<Department> findAll() {
        this.departmentList = this.departmentRepository.findAll();
        return this.departmentList;
    }

    @Override
    public Department findById(Long id) {
        if (this.departmentRepository.findById(id) != null) {
            Department department = (Department)this.departmentRepository.findById(id).get();
            return department;
        } else {
            return null;
        }
    }

    @Override
    public void deteleById(Long id) {
    }

    @Override
    public Department save(Department department) {
        return null;
    }

    @Override
    public Department update(Department department) {
        return null;
    }
}
