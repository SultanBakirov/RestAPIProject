package com.example.services.impls;

import com.example.convert.student.StudentRequestConvert;
import com.example.convert.student.StudentResponseConvert;
import com.example.dto.request.StudentRequest;
import com.example.dto.response.StudentResponse;
import com.example.models.entities.Student;
import com.example.repositories.StudentRepository;
import com.example.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final StudentRequestConvert studentRequestConvert;
    private final StudentResponseConvert studentResponseConvert;


    @Override
    public StudentResponse saveStudent(StudentRequest studentRequest) {
        Student student = studentRequestConvert.create(studentRequest);
        studentRepository.save(student);
        return studentResponseConvert.viewStudent(student);
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return studentResponseConvert.getAllLessons(studentRepository.findAll());
    }

    @Override
    public StudentResponse getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        return studentResponseConvert.viewStudent(student);
    }

    @Override
    public StudentResponse deleteStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        studentRepository.delete(student);
        return studentResponseConvert.viewStudent(student);
    }

    @Override
    public StudentResponse updateStudent(Long studentId, StudentRequest studentRequest) {
        Student student = studentRepository.findById(studentId).get();
        studentRequestConvert.update(student, studentRequest);
        return studentResponseConvert.viewStudent(studentRepository.save(student));
    }
}
