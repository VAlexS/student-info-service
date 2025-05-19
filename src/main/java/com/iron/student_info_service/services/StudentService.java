package com.iron.student_info_service.services;

import com.iron.student_info_service.models.Student;
import com.iron.student_info_service.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public ResponseEntity<?> getStudentById(int id){
        Optional<Student> foundStudent = studentRepository.findById(id);

        if (foundStudent.isPresent()){
            return new ResponseEntity<>(foundStudent.get(), HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
