package com.example.FirstApp.controller;


import com.example.FirstApp.dto.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @GetMapping("/student")
    public Student getStudent(){
        return new Student(1,"pankaj","12th-A");
    }

}
