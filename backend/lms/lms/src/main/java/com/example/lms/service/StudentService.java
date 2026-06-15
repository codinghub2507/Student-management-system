package com.example.lms.service;

import com.example.lms.model.Student;
import com.example.lms.repository.StudentRepository;
import com.example.lms.dto.StudentRequestDTO;
import com.example.lms.exception.StudentNotFoundException;

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
public Student getStudentById(Integer id){
    return repository.findById(id).orElseThrow(
        ()-> new StudentNotFoundException("Student Not Found With Id:"+id)
    );
}

public Student addStudent(StudentRequestDTO dto) {

    Student student = new Student();
    
    student.setName(dto.getName());
    student.setCourse(dto.getCourse());

    return repository.save(student);
}

public Student updateStudent(Integer id, StudentRequestDTO dto){

    Student student = repository
    .findById(id)
    .orElseThrow(() -> new StudentNotFoundException("Student not found with id: "+id));

    student.setName(dto.getName());
    // student.setCourse(dto.getCourse());

    return repository.save(student);
}

public String deleteStudent(Integer id){
    repository.deleteById(id);
    return "Student deleted with id: "+id;
}

}
