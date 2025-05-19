package com.iron.student_info_service.repositories;

import com.iron.student_info_service.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
