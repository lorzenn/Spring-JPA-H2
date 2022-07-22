package com.example.springdemo1.book;

import com.example.springdemo1.department.Department;
import com.example.springdemo1.department.DepartmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class BookConfig {

    @Bean
    CommandLineRunner bookCommandLineRunner(BookRepository bookRepository) {
        return  args -> {
            Book book1 = new Book(
                    "Design Patterns"
            );
            Book book2 = new Book(
                    "SRP"
            );
            Book book3 = new Book(
                    "DI"
            );

            bookRepository.saveAll(
                    Arrays.asList(book1, book2, book3)
            );
        };
    }
}
