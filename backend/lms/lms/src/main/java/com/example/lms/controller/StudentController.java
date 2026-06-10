package com.example.lms.controller;

import com.example.lms.model.Student;
// import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.lms.service.StudentService;
import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {
    // @GetMapping
    // public ArrayList<Student> getStudent(){

    //     ArrayList<Student> student= new ArrayList<>();
    //     student.add(new Student(101,"Manya","CSE"));
    //     student.add(new Student(102,"Vasudha","CSE"));

    //         return student;

    // }


    @Autowired
    private StudentService service;

    @GetMapping("/count")
    public String getStudentCount(){
        return service.getStudentCount();

    }

    @GetMapping
    public List<Student> getAllStudent(){
        return service.getAllStudents();
    }

    @PostMapping
public Student addStudent(@RequestBody Student student) {
    return service.saveStudent(student);
}

}
