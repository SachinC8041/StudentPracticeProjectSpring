package com.example.studentapiapplication.controller;

import com.example.studentapiapplication.model.Student;
import com.example.studentapiapplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class TeacherController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudentsForAdmin(){
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @DeleteMapping("/purge")
    public ResponseEntity<String> purgeAll() {
        int count = studentService.purgeAll(); // we’ll add this method
        return ResponseEntity.ok("Purged " + count + " students (ADMIN endpoint).");
    }
}
