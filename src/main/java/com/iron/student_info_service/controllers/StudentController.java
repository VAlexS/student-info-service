package com.iron.student_info_service.controllers;

import com.iron.student_info_service.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;



    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id){

        return studentService.getStudentById(id);
    }

}
