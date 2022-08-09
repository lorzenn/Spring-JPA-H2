package com.example.springdemo1.employee;

import java.util.List;


public interface EmployeeService {

    List<Employee> getEmployees();
    Employee getEmployee(Long empId);
    void createEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long empId);

}
