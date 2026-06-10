package com.example.lms.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

@Service


public class StudentService {
    public String getMessage(){
        return "Student Service is working";
    }

@Autowired
private JdbcTemplate jdbcTemplate;

public String getStudentCount(){
 String sql= "Select count(*) from student";
 return jdbcTemplate.queryForObject(sql,Integer.class).toString();
}
}
