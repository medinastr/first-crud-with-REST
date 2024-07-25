package com.medinastr.demo.rest;

import com.medinastr.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    // define @PostConstruct to load the student data
    @PostConstruct
    public void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Pedro", "Silva"));
        students.add(new Student("Verônica", "Vera"));
        students.add(new Student("Lucas", "Bernard"));
    }

    // define endpoint for "/students" - return a list of students
    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    // define endpoint or "/students/{studentId}" - return student at index
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        // check student ID
        if(studentId >= students.size() || studentId < 0) {
            throw new StudentNotFoundException("Student ID not found.");
        }
        return students.get(studentId);
    }
}
