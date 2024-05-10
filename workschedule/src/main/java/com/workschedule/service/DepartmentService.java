package com.workschedule.service;

import com.workschedule.model.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    Department findById(Long id);

    void deteleById(Long id);

    Department save(Department department);

    Department update(Department department);
}
