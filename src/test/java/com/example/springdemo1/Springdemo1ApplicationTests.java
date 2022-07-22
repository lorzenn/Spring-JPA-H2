package com.example.springdemo1;

import com.example.springdemo1.department.Department;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class Springdemo1ApplicationTests {

    @Value("${springdemo1.services.url}")
    private static final String BASE_URL = "http://localhost:8080/api/v1/";

    @Test
    void contextLoads() {
    }

    @Test
    public void testGetDepartment(){
        RestTemplate restTemplate = new RestTemplate();
        Department department = restTemplate.getForObject(BASE_URL + "department/get_department/1", Department.class);
        assertNotNull(department);
    }

}
