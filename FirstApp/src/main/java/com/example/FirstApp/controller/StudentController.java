package com.example.FirstApp.controller;


import com.example.FirstApp.dto.AddStudentRequestDto;
import com.example.FirstApp.dto.Student;
import com.example.FirstApp.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    private final StudentService studentService;

    StudentController(StudentService studentService){

        this.studentService=studentService;
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>>getStudent(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long studentId){
        return ResponseEntity.ok(studentService.getStudentById(studentId));
    }

    @PostMapping("/student")
    public ResponseEntity<Student> createStudent(@RequestBody @Valid AddStudentRequestDto addStudentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(addStudentRequestDto));
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable("id") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") Long studentId,@RequestBody AddStudentRequestDto addStudentRequestDto){
        Student student=studentService.updateStudent(studentId,addStudentRequestDto);
        return ResponseEntity.ok(student);
    }

    @PatchMapping("/student/{id}")
    public ResponseEntity<Student> updateStudentPartial(@PathVariable("id") Long studentId,@RequestBody Map<String,Object> updates){
        return ResponseEntity.ok(studentService.updateStudentPartial(studentId,updates));
    }

}
