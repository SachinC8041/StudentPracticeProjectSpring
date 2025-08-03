package com.example.StudentAPIApplication.service;

import com.example.StudentAPIApplication.model.Student;
import com.example.StudentAPIApplication.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void registerStudent(Student stu ){
        if (stu.getName().isEmpty() || stu.getStudentClass()<1){
            throw new IllegalArgumentException("Invalid student details");
        }
        studentRepository.saveStudent(stu);
    }

    public List<Student> getAllStudent(){
        return studentRepository.getAllStudentList();
    }

}
