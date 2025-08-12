package com.example.exceptionhandlingpractice.repository;

import com.example.exceptionhandlingpractice.model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepository {
    ArrayList<Student> studentDB = new ArrayList<>();

    public void saveStudent(Student student){
        studentDB.add(student);
    }

    public List<Student> getAllStudentList(){
        return studentDB;
    }

    public void deleteStudent(int studentId) {
        boolean removed = studentDB.removeIf(student -> student.getStudentId() == studentId);
        if (!removed) {
            throw new IllegalArgumentException("Student with ID " + studentId + " not found.");
        }
    }

    public int purgeAll() {
        int size = studentDB.size();
        studentDB.clear();
        return size;
    }

}
