package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(new Student(1L, "Miguel", "mrueda020@hotmail.com", 22, LocalDate.of(1998, Month.JULY, 3)));
    }
}
