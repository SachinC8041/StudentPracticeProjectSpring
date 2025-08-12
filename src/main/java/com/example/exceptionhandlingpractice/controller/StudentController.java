package com.example.exceptionhandlingpractice.controller;

import com.example.exceptionhandlingpractice.model.Student;
import com.example.exceptionhandlingpractice.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class StudentController {

    @Autowired
    private StudentService studentService;

    // USER endpoints (secured by hasRole('USER'))
    @PostMapping("/student/register")
    public ResponseEntity<String> registerStudentUser(@Valid @RequestBody Student student) {
        studentService.registerStu(student);
        return ResponseEntity.ok("Student registered successfully (USER endpoint)");
    }

    @GetMapping("/student/all")
    public ResponseEntity<List<Student>> getAllStudentDataUser() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @DeleteMapping("/student/delete/{studentId}")
    public ResponseEntity<String> deleteStudentUser(@PathVariable int studentId) {
        studentService.deleteStudent(studentId);
        return ResponseEntity.ok("Student with ID " + studentId + " deleted successfully. (USER endpoint)");
    }





    /*@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgument(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body("Invalid Student Data: " + ex.getMessage());
    }*/

}