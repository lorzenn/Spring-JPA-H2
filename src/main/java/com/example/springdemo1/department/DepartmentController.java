package com.example.springdemo1.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("get_departments")
    public List<Department> getDepartments() {
        return departmentService.getDepartments();
    }

    @GetMapping("{deptId}")
    public Department getDepartment(@PathVariable("deptId") Long deptId){
        return departmentService.getDepartment(deptId);
    }

    @PostMapping("/add")
    public void createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
    }

    @PutMapping("/update")
    public Department updateDepartment(@RequestBody Department department){
        return departmentService.updateDepartment(department);
    }

    @DeleteMapping("/delete/{deptId}")
    public void deleteDepartment(@PathVariable("deptId") Long deptId){
        departmentService.deleteDepartment(deptId);
    }

}
