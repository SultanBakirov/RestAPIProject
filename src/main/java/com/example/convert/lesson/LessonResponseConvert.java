package com.example.convert.lesson;

import com.example.dto.response.LessonResponse;
import com.example.models.entities.Lesson;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LessonResponseConvert {

    public LessonResponse viewLesson(Lesson lesson) {
        if (lesson == null) {
            return null;
        }
        LessonResponse lessonResponse = new LessonResponse();
        lessonResponse.setId(lesson.getId());
        lessonResponse.setLessonName(lesson.getLessonName());
        return lessonResponse;
    }

    public List<LessonResponse> getAllLessons(List<Lesson> lessons) {
        List<LessonResponse> lessonResponses = new ArrayList<>();
        for (Lesson lesson: lessons) {
            lessonResponses.add(viewLesson(lesson));
        }
        return lessonResponses;
    }
}
