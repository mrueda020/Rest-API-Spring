package com.example.demo.student;

import java.util.List;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student Miguel = new Student("Miguel", "mrueda020@hotmail.com", LocalDate.of(1998, Month.JULY, 3));
            Student Miriam = new Student("Miriam", "miriam@hotmail.com", LocalDate.of(2001, Month.FEBRUARY, 28));
            repository.saveAll(List.of(Miguel, Miriam));
        };
    }

}
