package com.example.FirstApp.service.impl;

import com.example.FirstApp.dto.Student;
import com.example.FirstApp.entity.StudentEntity;
import com.example.FirstApp.repository.StudentRepository;
import com.example.FirstApp.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }


    @Override
    public List<Student> getAllStudents() {
       List<StudentEntity> list=studentRepository.findAll();
       List<Student> newList=list
               .stream()
               .map(student-> new Student(student.getId(),student.getName(),student.getEmail()))
               .toList();
       return newList;
    }


}
