package com.example.services;

import com.example.dto.request.StudentRequest;
import com.example.dto.response.StudentResponse;

import java.util.List;

public interface StudentService {

    StudentResponse saveStudent(StudentRequest studentRequest);

    List<StudentResponse> getAllStudents();

    StudentResponse getStudentById(Long studentId);

    StudentResponse deleteStudentById(Long studentId);

    StudentResponse updateStudent(Long studentId, StudentRequest studentRequest);

}
