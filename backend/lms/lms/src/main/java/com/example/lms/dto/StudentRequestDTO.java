package com.example.lms.dto;

public class StudentRequestDTO{

    public String name;
    public String course;

    public StudentRequestDTO(String name,String course){
        this.name=name;
        this.course=course;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name= name;
    }
    public String getCourse(){
        return course;
    }
    public void setCourse(String course){
        this.course= course;
    }
}