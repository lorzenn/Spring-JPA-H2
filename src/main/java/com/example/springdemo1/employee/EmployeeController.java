package com.example.springdemo1.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("get_employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("{empId}")
    public Employee getEmployee(@PathVariable("empId") Long empId){
        return employeeService.getEmployee(empId);
    }

    @PostMapping("/add")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/{empId}")
    public void deleteEmployee(@PathVariable("empId") Long empId){
        employeeService.deleteEmployee(empId);
    }

}
