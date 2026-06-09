package com.example.lms.controller;

import com.example.lms.model.Student;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
    @GetMapping
    public ArrayList<Student> getStudent(){

        ArrayList<Student> student= new ArrayList<>();
        student.add(new Student(101,"Manya","CSE"));
        student.add(new Student(102,"Vasudha","CSE"));

            return student;

    }

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/count")
    public int countStudents(){
        String sql ="SELECT COUNT(*) FROM Students";
                return jdbcTemplate.queryForObject(
                sql,
                Integer.class
                );
    }
}
