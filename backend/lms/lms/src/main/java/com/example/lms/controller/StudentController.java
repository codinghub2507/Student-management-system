package com.example.lms.controller;

import com.example.lms.model.Student;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5173")
public class StudentController {
    
    public Student getStudent(){
        return new Student(101,"Vasudha","CSE");
    }
}
