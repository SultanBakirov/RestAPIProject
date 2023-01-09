package com.example.services;

import com.example.dto.request.LessonRequest;
import com.example.dto.response.LessonResponse;

import java.util.List;

public interface LessonService {

    LessonResponse saveLesson(LessonRequest lessonRequest);

    List<LessonResponse> getAllLessons();

    LessonResponse getLessonById(Long lessonId);

    LessonResponse deleteLessonById(Long lessonId);

    LessonResponse updateLesson(Long lessonId, LessonRequest lessonRequest);

}
