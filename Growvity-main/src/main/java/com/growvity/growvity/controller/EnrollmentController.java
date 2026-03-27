package com.growvity.growvity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.growvity.growvity.ApiResponse.ApiResponse;
import com.growvity.growvity.model.Enrollment;
import com.growvity.growvity.service.EnrollmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Enrollment>>> getAllEnrollments() {

        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "Enrollments retrieved successfully",
                        enrollments,
                        true
                )
        );
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Enrollment>> createEnrollment(
            @RequestBody Enrollment enrollment) {

        Enrollment savedEnrollment = enrollmentService.saveEnrollment(enrollment);

        return ResponseEntity.status(201).body(
                new ApiResponse<>(
                        "Enrollment created successfully",
                        savedEnrollment,
                        true));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteEnrollment(@PathVariable Long id){

        enrollmentService.deleteEnrollment(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Deleted successfully", null, true)
        );
    }
}