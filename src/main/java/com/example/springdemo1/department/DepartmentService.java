package com.example.springdemo1.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> getDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartment(Long id) {
        return departmentRepository.findById(id).get();
    }

    public void createDepartment(Department department) {
        new ResponseEntity<>(departmentRepository.save(department), HttpStatus.CREATED);
    }

    public Department updateDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public void deleteDepartment(Long deptId) {
        departmentRepository.deleteById(deptId);
    }


}
