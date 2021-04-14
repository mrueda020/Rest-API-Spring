package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Make this class a Restful API
@RequestMapping(path = "api/v1/student")
public class StudentController {
    @GetMapping
    public List<Student> getStudents() {
        return List.of(new Student(1L, "Miguel", "mrueda020@hotmail.com", 22, LocalDate.of(1998, Month.JULY, 3)));

    }
}