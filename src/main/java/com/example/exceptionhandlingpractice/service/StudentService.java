package com.example.exceptionhandlingpractice.service;

import com.example.exceptionhandlingpractice.model.Student;
import com.example.exceptionhandlingpractice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepo;

    public void registerStu(Student student){
        if (student.getStudentName().isEmpty() || student.getStudentId()<1 ){
            throw new IllegalArgumentException("Invalid student details");
        }
        studentRepo.saveStudent(student);
    }

    public List<Student> getAllStudent(){
        return studentRepo.getAllStudentList();
    }
}
