package com.example.springdemo1.tasks;

import java.util.List;

public interface TaskService {

    List<Task> getTasks();
    Task getTask(Long taskId);
    void createTask(Task task);
    Task updateTask(Task task);
    void deleteTask(Long taskId);
}
