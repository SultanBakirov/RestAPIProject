package com.example.api;

import com.example.dto.request.InstructorRequest;
import com.example.dto.response.InstructorResponse;
import com.example.services.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/instructor")
public class InstructorController {

    private final InstructorService instructorService;

    @PostMapping("/save")
    public InstructorResponse saveInstructor(@RequestBody InstructorRequest instructorRequest) {
        return instructorService.saveInstructor(instructorRequest);
    }

    @GetMapping("/getAll")
    public List<InstructorResponse> getAllInstructors() {
        return instructorService.getAllInstructors();
    }

    @GetMapping("/{instructorId}")
    public InstructorResponse getInstructorById(@PathVariable Long instructorId) {
        return instructorService.getInstructorById(instructorId);
    }

    @PatchMapping("/{instructorId}")
    public InstructorResponse updateInstructor(@PathVariable Long instructorId, @RequestBody InstructorRequest instructorRequest) {
        return instructorService.updateInstructor(instructorId, instructorRequest);
    }

    @DeleteMapping("/{instructorId}")
    public InstructorResponse deleteInstructorById(@PathVariable Long instructorId) {
        return instructorService.deleteInstructorById(instructorId);
    }
}
