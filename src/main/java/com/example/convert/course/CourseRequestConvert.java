package com.example.convert.course;

import com.example.dto.request.CourseRequest;
import com.example.models.entities.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseRequestConvert {

    public Course create(CourseRequest courseRequest) {
        if (courseRequest == null) {
            return null;
        }
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        course.setDescription(courseRequest.getDescription());
        return course;
    }

    public void update(Course course, CourseRequest courseRequest) {
        course.setCourseName(courseRequest.getCourseName());
        course.setDuration(courseRequest.getDuration());
        course.setDescription(courseRequest.getDescription());
    }
}
