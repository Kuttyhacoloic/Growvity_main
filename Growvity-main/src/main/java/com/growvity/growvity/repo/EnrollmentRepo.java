package com.growvity.growvity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.growvity.growvity.model.Enrollment;

public interface EnrollmentRepo extends JpaRepository<Enrollment, Long>{

}
