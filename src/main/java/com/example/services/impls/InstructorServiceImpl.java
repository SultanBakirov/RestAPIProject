package com.example.services.impls;

import com.example.convert.instructor.InstructorRequestConvert;
import com.example.convert.instructor.InstructorResponseConvert;
import com.example.dto.request.InstructorRequest;
import com.example.dto.response.InstructorResponse;
import com.example.models.entities.Instructor;
import com.example.repositories.InstructorRepository;
import com.example.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;
    private final InstructorRequestConvert instructorRequestConvert;
    private final InstructorResponseConvert instructorResponseConvert;

    @Override
    public InstructorResponse saveInstructor(InstructorRequest instructorRequest) {
        Instructor instructor = instructorRequestConvert.create(instructorRequest);
        instructorRepository.save(instructor);
        return instructorResponseConvert.viewInstructor(instructor);
    }

    @Override
    public List<InstructorResponse> getAllInstructors() {
        return instructorResponseConvert.getAllInstructors(instructorRepository.findAll());
    }

    @Override
    public InstructorResponse getInstructorById(Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).get();
        return instructorResponseConvert.viewInstructor(instructor);
    }

    @Override
    public InstructorResponse deleteInstructorById(Long instructorId) {
        Instructor instructor = instructorRepository.findById(instructorId).get();
        instructorRepository.delete(instructor);
        return instructorResponseConvert.viewInstructor(instructor);
    }

    @Override
    public InstructorResponse updateInstructor(Long instructorId, InstructorRequest instructorRequest) {
        Instructor instructor = instructorRepository.findById(instructorId).get();
        instructorRequestConvert.update(instructor, instructorRequest);
        return instructorResponseConvert.viewInstructor(instructorRepository.save(instructor));
    }
}
