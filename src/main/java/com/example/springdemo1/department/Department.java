package com.example.springdemo1.department;

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
