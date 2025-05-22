package com.iron.student_info_service.clients;

import com.iron.student_info_service.dto.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "grades-data-service")
public interface UserFeignClient {

    @GetMapping("/api/course/{courseCode}")
    CourseDTO getCourseByCourseCode(@PathVariable String courseCode);
}
