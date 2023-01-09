package com.example.services.impls;

import com.example.convert.lesson.LessonRequestConvert;
import com.example.convert.lesson.LessonResponseConvert;
import com.example.dto.request.LessonRequest;
import com.example.dto.response.LessonResponse;
import com.example.models.entities.Lesson;
import com.example.repositories.LessonRepository;
import com.example.services.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LessonServiceImpl implements LessonService {

    private final LessonRepository lessonRepository;
    private final LessonRequestConvert lessonRequestConvert;
    private final LessonResponseConvert lessonResponseConvert;


    @Override
    public LessonResponse saveLesson(LessonRequest lessonRequest) {
        Lesson lesson = lessonRequestConvert.create(lessonRequest);
        lessonRepository.save(lesson);
        return lessonResponseConvert.viewLesson(lesson);
    }

    @Override
    public List<LessonResponse> getAllLessons() {
        return lessonResponseConvert.getAllLessons(lessonRepository.findAll());
    }

    @Override
    public LessonResponse getLessonById(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).get();
        return lessonResponseConvert.viewLesson(lesson);
    }

    @Override
    public LessonResponse deleteLessonById(Long lessonId) {
        Lesson lesson = lessonRepository.findById(lessonId).get();
        lessonRepository.delete(lesson);
        return lessonResponseConvert.viewLesson(lesson);
    }

    @Override
    public LessonResponse updateLesson(Long lessonId, LessonRequest lessonRequest) {
        Lesson lesson = lessonRepository.findById(lessonId).get();
        lessonRequestConvert.update(lesson, lessonRequest);
        return lessonResponseConvert.viewLesson(lessonRepository.save(lesson));
    }
}
