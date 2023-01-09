package com.example.services.impls;

import com.example.convert.course.CourseRequestConvert;
import com.example.convert.course.CourseResponseConvert;
import com.example.dto.request.CourseRequest;
import com.example.dto.response.CourseResponse;
import com.example.models.entities.Course;
import com.example.repositories.CourseRepository;
import com.example.services.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseRequestConvert courseRequestConvert;
    private final CourseResponseConvert courseResponseConvert;

    @Override
    public CourseResponse saveCourse(CourseRequest courseRequest) {
        Course course = courseRequestConvert.create(courseRequest);
        courseRepository.save(course);
        return courseResponseConvert.viewCourse(course);
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseResponseConvert.getAllCourses(courseRepository.findAll());
    }

    @Override
    public CourseResponse getCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        return courseResponseConvert.viewCourse(course);
    }

    @Override
    public CourseResponse deleteCourseById(Long courseId) {
        Course course = courseRepository.findById(courseId).get();
        courseRepository.delete(course);
        return courseResponseConvert.viewCourse(course);
    }

    @Override
    public CourseResponse updateCourse(Long courseId, CourseRequest courseRequest) {
        Course course = courseRepository.findById(courseId).get();
        courseRequestConvert.update(course, courseRequest);
        return courseResponseConvert.viewCourse(courseRepository.save(course));
    }
}
