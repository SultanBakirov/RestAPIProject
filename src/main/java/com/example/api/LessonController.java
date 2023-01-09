package com.example.api;

import com.example.dto.request.LessonRequest;
import com.example.dto.response.LessonResponse;
import com.example.services.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {

    private final LessonService lessonService;

    @PostMapping("/save")
    public LessonResponse saveLesson(@RequestBody LessonRequest lessonRequest) {
        return lessonService.saveLesson(lessonRequest);
    }

    @GetMapping("/getAll")
    public List<LessonResponse> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping("/{lessonId}")
    public LessonResponse getLessonById(@PathVariable Long lessonId) {
        return lessonService.getLessonById(lessonId);
    }

    @PutMapping("/{lessonId}")
    public LessonResponse updateLesson(@PathVariable Long lessonId, @RequestBody LessonRequest lessonRequest) {
        return lessonService.updateLesson(lessonId, lessonRequest);
    }

    @DeleteMapping("/{lessonId}")
    public LessonResponse deleteLessonById(@PathVariable Long lessonId) {
        return lessonService.deleteLessonById(lessonId);
    }
}
