package com.example.exceptionhandlingpractice.controller;

import com.example.exceptionhandlingpractice.model.Student;
import com.example.exceptionhandlingpractice.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ex/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<String> registerStudent(@RequestBody Student student) {
        studentService.registerStu(student);
        return ResponseEntity.ok("Student registered successfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudentData(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    /*@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body("Invalid Student Data: " + ex.getMessage());
    }*/


}
