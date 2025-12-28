package com.example.FirstApp.controller;


import com.example.FirstApp.dto.Student;
import com.example.FirstApp.service.StudentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    StudentController(StudentService studentService){

        this.studentService=studentService;
    }

    @GetMapping("/student")
    public List<Student> getStudent(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{id}")
    public String getStudentById(@PathVariable("id") Long studentId){
        return "This is student "+studentId;
    }

}
