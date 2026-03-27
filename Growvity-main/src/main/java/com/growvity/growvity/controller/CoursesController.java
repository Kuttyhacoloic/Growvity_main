package com.growvity.growvity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.growvity.growvity.ApiResponse.ApiResponse;
import com.growvity.growvity.model.Courses;
import com.growvity.growvity.service.CoursesService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CoursesController {

    private final CoursesService coursesService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Courses>>> getAllCourses(){

        List<Courses> courses = coursesService.getAllCourses();

        return ResponseEntity.ok(
                new ApiResponse<>("Courses fetched successfully", courses, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Courses>> getCourse(@PathVariable Long id){

        Courses course = coursesService.getCourse(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Course found", course, true));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Courses>> createCourse(@RequestBody Courses course){

        Courses saved = coursesService.saveCourse(course);

        return ResponseEntity.ok(
                new ApiResponse<>("Course created successfully", saved, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Courses>> updateCourse(
            @PathVariable Long id,
            @RequestBody Courses course){

        Courses updated = coursesService.updateCourse(id, course);

        return ResponseEntity.ok(
                new ApiResponse<>("Course updated successfully", updated, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteCourse(@PathVariable Long id){

        coursesService.deleteCourse(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Course deleted successfully", null, true));
    }
}