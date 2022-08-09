package com.example.springdemo1.tasks;

import com.example.springdemo1.department.Department;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Task {

    @Id
    @SequenceGenerator(
            name = "task_sequence",
            sequenceName = "task_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_sequence"
    )
    private Long taskId;
    private String taskName;

    @OneToOne(mappedBy = "taskTable")
    private Department deptTask;

    public Task() {
    }

    public Task(Long taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public Task(String taskName) {
        this.taskName = taskName;
    }

}