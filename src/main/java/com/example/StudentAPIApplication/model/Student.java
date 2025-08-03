package com.example.StudentAPIApplication.model;

public class Student {
    private String name;
    private int studentClass;

    public Student(){

    };

    public Student(String name, int studentClass){
        this.name = name;
        this.studentClass = studentClass;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(int studentClass) {
        this.studentClass = studentClass;
    }
}
