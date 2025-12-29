package com.example.FirstApp.service.impl;

import com.example.FirstApp.dto.AddStudentRequestDto;
import com.example.FirstApp.dto.Student;
import com.example.FirstApp.entity.StudentEntity;
import com.example.FirstApp.repository.StudentRepository;
import com.example.FirstApp.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public Student getStudentById(Long id){
        StudentEntity student=studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with the id "+id));
        return new Student(student.getId(),student.getName(),student.getEmail());
    }
    @Override
    public Student createStudent(AddStudentRequestDto addStudentRequestDto){
        StudentEntity student=new StudentEntity(addStudentRequestDto.getName(),addStudentRequestDto.getEmail());
       StudentEntity newStudent= studentRepository.save(student);
       Student newStudentDto=new Student(newStudent.getId(),newStudent.getName(), newStudent.getEmail());
       return newStudentDto;
    }

    @Override
    public void deleteStudent(Long id) {

        if(!studentRepository.existsById(id)){
            throw new IllegalArgumentException("Student not found with id : "+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id, AddStudentRequestDto addStudentRequestDto) {

        StudentEntity student=studentRepository
                .findById(id)
                .orElseThrow(()->new IllegalArgumentException("Student not found with the id "+id));
        if(addStudentRequestDto.getEmail()!=null){
            student.setEmail(addStudentRequestDto.getEmail());
        }
        if(addStudentRequestDto.getName()!=null){
            student.setName(addStudentRequestDto.getName());
        }
        studentRepository.save(student);
        return new Student(student.getId(),student.getName(), student.getEmail());
    }

    @Override
    public Student updateStudentPartial(Long id, Map<String, Object> updates) {

        StudentEntity student=studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Student not found with id : "+id));

        updates.forEach((field,value)->{
                    switch (field){
                        case "email":student.setEmail((String) value);
                        break;
                        case "name":student.setName((String) value);
                        break;
                        default:
                            throw new IllegalArgumentException("No such fields exists");
                    }
        });
        studentRepository.save(student);
        return new Student(student.getId(),student.getName(),student.getEmail());
    }

}
