package com.iron.student_info_service.dto;

import com.iron.student_info_service.models.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponseDTO {

    private int id;

    private String name;

    private int age;

    private String courseCode;

    private CourseDTO course;

    public StudentResponseDTO(Student student, CourseDTO courseDTO){
        setId(student.getId());
        setAge(student.getAge());
        setName(student.getName());
        setCourseCode(student.getCourseCode());
        setCourse(courseDTO);
    }


}
