package com.example.convert.course;

import com.example.dto.response.CourseResponse;
import com.example.models.entities.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CourseResponseConvert {

    public CourseResponse viewCourse(Course course) {
        if (course == null) {
            return null;
        }
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setId(course.getId());
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setDuration(course.getDuration());
        courseResponse.setDescription(course.getDescription());
        return courseResponse;
    }

    public List<CourseResponse> getAllCourses(List<Course> courses) {
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course: courses) {
            courseResponses.add(viewCourse(course));
        }
        return courseResponses;
    }
}
