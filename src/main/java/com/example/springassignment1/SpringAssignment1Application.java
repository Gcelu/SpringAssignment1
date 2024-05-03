package com.example.springassignment1;

import jakarta.validation.Valid;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
public class SpringAssignment1Application {
    private List<Course> courses = new CopyOnWriteArrayList<>();
Course course = new Course();
    public static void main(String[] args) {
        SpringApplication.run(SpringAssignment1Application.class, args);
    }

    @GetMapping("/foundation.html")
    public List<String> getFoundationCourses() {
        return List.of("CSC 111F", "CSC 121F");
    }

    @GetMapping("/undergraduate.html")
    public List<String> getUndergraduateCourses() {
        return List.of("CSC 111", "CSC 121", "CSC 211", "CSC 223", "CSC 313");
    }

    @GetMapping("/honours.html")
    public List<String> getHonoursCourses() {
        return List.of("CSC 501", "CSC 511", "CSC 521", "CSC 522");
    }

    @PostMapping("/courses")
    public Course createCourse(@Valid @RequestBody Course course) {
        courses.add(course);
        return course;
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courses;
    }

    @GetMapping("/courses/{id}")
    public Course getCourseById(@PathVariable int id) {
        return courses.stream()
                .filter(course -> course.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable int id, @RequestBody Course updatedCourse) {
        for (Course course : courses) {
            if (course.getId() == id) {
                course.setName(updatedCourse.getName());
                course.setCode(updatedCourse.getCode());
                return course;
            }
        }
        return null;
    }

    @DeleteMapping("/courses/{id}")
    public void deleteCourse(@PathVariable int id) {
        courses.removeIf(course -> course.getId() == id);
    }
}
