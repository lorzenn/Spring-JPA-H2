package com.example.springdemo1.employee;

import com.example.springdemo1.department.Department;
import com.example.springdemo1.tasks.Task;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Employee {

    @Id
    @SequenceGenerator(
            name = "employee_sequence",
            sequenceName = "employee_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )
    private Long empId;
    private String employeeName;
    private String qrCode;
    private String pic;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id", referencedColumnName = "taskId")
    private Task taskTable;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dept_id", referencedColumnName = "deptId")
    private Department deptTable;

//    @OneToOne(mappedBy = "empTable")
//    private Department deptEmployee;

    public Employee() {
    }

    public Employee(Long empId, String employeeName, String qrCode, String pic) {
        this.empId = empId;
        this.employeeName = employeeName;
        this.qrCode = qrCode;
        this.pic = pic;
    }

    public Employee(String employeeName, String qrCode, String pic) {
        this.employeeName = employeeName;
        this.qrCode = qrCode;
        this.pic = pic;
    }

}
