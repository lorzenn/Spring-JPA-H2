package com.example.springdemo1.department;

import java.util.List;

public interface DepartmentService {

    List<Department> getDepartments();
    Department getDepartment(Long deptId);
    void createDepartment(Department department);
    Department updateDepartment(Department department);
    void deleteDepartment(Long deptId);

}
