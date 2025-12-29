package com.example.FirstApp.service;

import com.example.FirstApp.dto.AddStudentRequestDto;
import com.example.FirstApp.dto.Student;

import java.util.List;
import java.util.Map;


public interface StudentService {

    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(AddStudentRequestDto student);
    void deleteStudent(Long id);

    Student updateStudent(Long studentId, AddStudentRequestDto addStudentRequestDto);

    Student updateStudentPartial(Long studentId, Map<String, Object> updates);
}
