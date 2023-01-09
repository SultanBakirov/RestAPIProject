package com.example.convert.lesson;

import com.example.dto.request.LessonRequest;
import com.example.models.entities.Lesson;
import org.springframework.stereotype.Component;

@Component
public class LessonRequestConvert {

    public Lesson create(LessonRequest lessonRequest) {
        if (lessonRequest == null) {
            return null;
        }
        Lesson lesson = new Lesson();
        lesson.setLessonName(lessonRequest.getLessonName());
        return lesson;
    }

    public void update(Lesson lesson, LessonRequest lessonRequest) {
        lesson.setLessonName(lessonRequest.getLessonName());
    }
}
