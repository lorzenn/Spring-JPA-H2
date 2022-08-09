package com.example.springdemo1.department;

import com.example.springdemo1.employee.Employee;
import com.example.springdemo1.tasks.Task;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Department {

    @Id
    @SequenceGenerator(
            name = "department_sequence",
            sequenceName = "department_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "department_sequence"
    )
    private Long deptId;
    private String departmentName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", referencedColumnName = "taskId")
    private Task taskTable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "emp_id", referencedColumnName = "empId")
    private Employee empTable;

//    @OneToOne(mappedBy = "deptTable")
//    private Employee deptEmployee;


    public Department() {
    }

    public Department(Long deptId, String departmentName) {
        this.deptId = deptId;
        this.departmentName = departmentName;
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }



}
