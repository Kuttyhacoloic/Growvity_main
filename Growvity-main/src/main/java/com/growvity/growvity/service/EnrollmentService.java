
package com.growvity.growvity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growvity.growvity.globalException.BadRequestException;
import com.growvity.growvity.globalException.ResourceNotFoundException;
import com.growvity.growvity.model.Enrollment;
import com.growvity.growvity.repo.EnrollmentRepo;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepo enrollmentRepo;

    public List<Enrollment> getAllEnrollments(){
        return enrollmentRepo.findAll();
    }

    public Enrollment getEnrollment(Long id){
        return enrollmentRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Enrollment not found with id: " + id));
    }

    public Enrollment saveEnrollment(Enrollment enrollment){

        if(enrollment.getCourse() == null || enrollment.getStudent() == null){
            throw new BadRequestException("CourseId and StudentId are required");
        }

        return enrollmentRepo.save(enrollment);
    }

    public Enrollment updateEnrollment(Long id, Enrollment updated){

        Enrollment existing = getEnrollment(id);

        if(updated.getStatus() != null){
            existing.setStatus(updated.getStatus());
        }

        return enrollmentRepo.save(existing);
    }

    public void deleteEnrollment(Long id){
        Enrollment enrollment = getEnrollment(id);
        enrollmentRepo.delete(enrollment);
    }
}