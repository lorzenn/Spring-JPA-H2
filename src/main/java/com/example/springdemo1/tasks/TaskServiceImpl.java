package com.example.springdemo1.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{


    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTask(Long taskId) {
        return taskRepository.findById(taskId).get();
    }

    public void createTask(Task task) {
        new ResponseEntity<>(taskRepository.save(task), HttpStatus.CREATED);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
    }
}
