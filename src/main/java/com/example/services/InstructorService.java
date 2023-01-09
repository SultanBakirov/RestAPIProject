package com.example.services;

import com.example.dto.request.InstructorRequest;
import com.example.dto.response.InstructorResponse;

import java.util.List;

public interface InstructorService {

    InstructorResponse saveInstructor(InstructorRequest instructorRequest);

    List<InstructorResponse> getAllInstructors();

    InstructorResponse getInstructorById(Long instructorId);

    InstructorResponse deleteInstructorById(Long instructorId);

    InstructorResponse updateInstructor(Long instructorId, InstructorRequest instructorRequest);

}
