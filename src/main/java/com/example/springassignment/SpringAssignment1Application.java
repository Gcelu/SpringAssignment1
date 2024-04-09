package com.example.springassignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;


@SpringBootApplication
@RestController

public class SpringAssignment1Application {
    public static void main(String[] args){
        SpringApplication.run(SpringAssignment1Application.class, args);
    }


    @GetMapping("/foundation-courses")// lists of 2 foundation courses
    public List<String> getFoundationCourses() {
        return Arrays.asList("CSC 111F", "CSC 121F");
    }

    @GetMapping("/undergraduate-courses")// lists of 5 undergraduate courses
    public List<String> getUndergraduateCourses() {
        return Arrays.asList("CSC 111", "CSC 121", "CSC 211", "CSC 223", "CSC 313");
    }

    @GetMapping("/honours-courses")// lists of 4 honours courses
    public List<String> getHonoursCourses() {
        return Arrays.asList("CSC 501", "CSC 511",  "CSC 521","CSC 522");
    }
}