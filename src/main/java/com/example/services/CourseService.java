package com.example.services;

import com.example.dto.request.CourseRequest;
import com.example.dto.response.CourseResponse;

import java.util.List;

public interface CourseService {

    CourseResponse saveCourse(CourseRequest courseRequest);

    List<CourseResponse> getAllCourses();

    CourseResponse getCourseById(Long courseId);

    CourseResponse deleteCourseById(Long courseId);

    CourseResponse updateCourse(Long courseId, CourseRequest courseRequest);

}
