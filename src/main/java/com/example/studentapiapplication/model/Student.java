package com.example.studentapiapplication.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Student {
    @Min(1)
    private int studentId;

    @NotBlank
    private String studentName;

    @Email @NotBlank
    private String email;

    public Student(){
    };
    public Student(int studentId, String studentName, String email){
        this.studentId = studentId;
        this.studentName = studentName;
        this.email = email;
    }

    public int getStudentId() {
        return studentId;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
