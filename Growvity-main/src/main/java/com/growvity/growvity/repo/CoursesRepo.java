package com.growvity.growvity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.growvity.growvity.model.Courses;

public interface CoursesRepo extends JpaRepository<Courses, Long> {

}
