package com.example.springdemo1.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner employeeCommandLineRunner(EmployeeRepository employeeRepository) {
        return  args -> {
            Employee emp1 = new Employee(
                    "Lorenz",
                    "lorenz qr code",
                    "lorenz pic"
            );
            Employee emp2 = new Employee(
                    "JP",
                    "JP qr code",
                    "JP pic"
            );
            Employee emp3 = new Employee(
                    "Jonathan",
                    "Jonathan qr code",
                    "Jonathan pic"
            );

            employeeRepository.saveAll(
                    Arrays.asList(emp1, emp2, emp3)
            );
        };
    }
}
