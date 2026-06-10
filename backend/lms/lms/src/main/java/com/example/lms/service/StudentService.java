package com.example.lms.service;

import com.example.lms.model.Student;
import com.example.lms.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service


public class StudentService {
    public String getMessage(){
        return "Student Service is working";
    }

@Autowired
private JdbcTemplate jdbcTemplate;

@Autowired
private StudentRepository repository;

public String getStudentCount(){
 String sql= "Select count(*) from student";
 return jdbcTemplate.queryForObject(sql,Integer.class).toString();
}

public Student saveStudent( Student student) {
    return repository.save(student);
}

public List<Student> getAllStudents(){
    return repository.findAll();
}
}
