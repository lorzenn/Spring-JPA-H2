package com.example.springdemo1.tasks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("get_tasks")
    public List<Task> getTasks() {
        return taskService.getTasks();
    }

    @GetMapping("{taskId}")
    public Task getTask(@PathVariable("taskId") Long taskId){
        return taskService.getTask(taskId);
    }

    @PostMapping("/add")
    public void createEmployee(@RequestBody Task task){
        taskService.createTask(task);
    }

    @PutMapping("/update")
    public Task updateTask(@RequestBody Task task){
        return taskService.updateTask(task);
    }

    @DeleteMapping("/delete/{taskId}")
    public void deleteEmployee(@PathVariable("taskId") Long taskId){
        taskService.deleteTask(taskId);
    }

}
