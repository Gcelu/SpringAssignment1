package com.example.springassignment1;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class Course {
    @Min(1)
    private int id;

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank(message = "Code is mandatory")
    @Size(min = 3, max = 10)
    private String code;

    public Course() {
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getCode() {
        return code;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCode(String code) {
        this.code = code;
    }
}