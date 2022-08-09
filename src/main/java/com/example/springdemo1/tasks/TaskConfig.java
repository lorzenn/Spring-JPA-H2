package com.example.springdemo1.tasks;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TaskConfig {
    
    @Bean
    CommandLineRunner taskCommandLineRunner(TaskRepository taskRepository) {
        return  args -> {
            Task t1 = new Task("task1");
            Task t2 = new Task("JP");
            Task t3 = new Task("Jonathan");

            taskRepository.saveAll(
                    Arrays.asList(t1, t2, t3)
            );
        };
    }

}
