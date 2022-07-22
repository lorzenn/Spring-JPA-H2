package com.example.springdemo1.department;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class DepartmentConfig {

    @Bean
    CommandLineRunner departmentCommandLineRunner(DepartmentRepository departmentRepository) {
        return  args -> {
            Department bib = new Department(
                    "BIB"
            );
            Department hk = new Department(
                    "HK"
            );
            Department ef = new Department(
                    "EF"
            );

            departmentRepository.saveAll(
                    Arrays.asList(bib, hk, ef)
            );
        };
    }

}
