package com.iron.student_info_service.services;

import com.iron.student_info_service.clients.UserFeignClient;
import com.iron.student_info_service.dto.CourseDTO;
import com.iron.student_info_service.dto.StudentResponseDTO;
import com.iron.student_info_service.models.Student;
import com.iron.student_info_service.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserFeignClient userFeignClient;


    public ResponseEntity<?> getStudentById(int id){
        Optional<Student> foundStudent = studentRepository.findById(id);

        if (foundStudent.isPresent()){

            Student student = foundStudent.get();


            CourseDTO course = userFeignClient.getCourseByCourseCode(student.getCourseCode());


            StudentResponseDTO response = new StudentResponseDTO(student, course);


            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
