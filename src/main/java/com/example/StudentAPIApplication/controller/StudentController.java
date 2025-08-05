package com.example.StudentAPIApplication.controller;

import com.example.StudentAPIApplication.model.Student;
import com.example.StudentAPIApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Student student) {
        studentService.registerStudent(student);
        return ResponseEntity.ok("Student registered successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAll() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/search")
    public ResponseEntity<String> search(@RequestParam String name, @RequestParam int age) {
        return ResponseEntity.ok("Searching for: " + name + ", age: " + age);
    }

}
