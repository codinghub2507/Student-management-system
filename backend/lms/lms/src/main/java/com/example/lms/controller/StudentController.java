package com.example.lms.controller;

import com.example.lms.dto.StudentRequestDTO;
import com.example.lms.dto.StudentResponseDTO;
import com.example.lms.model.Student;
// import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.lms.service.StudentService;
import java.util.List;
import java.util.Map;

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

//     @PostMapping
// public Student addStudent(@RequestBody Student student) {
//     return service.saveStudent(student);
// }

@GetMapping("/{id}")
public ResponseEntity<?> getStudent(@PathVariable("id")Integer id){
Student student =service.getStudentById(id);

StudentResponseDTO responseDTO= new StudentResponseDTO(
    student.getId(),
    student.getName(),
    student.getCourse()
);
return ResponseEntity.ok(responseDTO);
}
@PostMapping //new will not be there as REST API only support recourse not keywords like that
public ResponseEntity<?> addStudent(@RequestBody StudentRequestDTO dto) {

    Student student = service.addStudent(dto);

    return ResponseEntity.ok(student);
}

@PutMapping("/{id}")
public ResponseEntity<?> updateStudent(@PathVariable("id") Integer id, @RequestBody StudentRequestDTO dto){
    Student student=service.updateStudent(id,dto);

    StudentResponseDTO responseDTO= new StudentResponseDTO(
        student.getId(),
        student.getName(),
        student.getCourse()
    );
    return ResponseEntity.ok(responseDTO);
}
@DeleteMapping("/{id}")
public ResponseEntity<?> deleteStudent(@PathVariable Integer id){
    return ResponseEntity.ok(Map.of("message:",service.deleteStudent(id))
    );
}
}
