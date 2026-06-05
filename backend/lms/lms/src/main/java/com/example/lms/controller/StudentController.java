package com.example.lms.controller;

import com.example.lms.model.Student;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
    @GetMapping
    public Student getStudent(){
        return new Student(101,"Vasudha","CSE");
    }
}
