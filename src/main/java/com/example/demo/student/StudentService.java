package com.example.demo.student;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByemail = this.studentRepository.findStudentByEmail(student.getEmail());
        if (studentByemail.isPresent()) {
            throw new IllegalStateException("Email is taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long StudentId) {
        boolean exists = studentRepository.existsById(StudentId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + StudentId + " does not exists");
        }
        studentRepository.deleteById(StudentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exists"));

        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }

        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            Optional<Student> studentByemail = this.studentRepository.findStudentByEmail(email);
            if (studentByemail.isPresent()) {
                throw new IllegalStateException("Email is taken");
            }
            student.setEmail(email);
        }

    }
}
