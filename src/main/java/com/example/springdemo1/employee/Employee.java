package com.example.springdemo1.employee;

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
