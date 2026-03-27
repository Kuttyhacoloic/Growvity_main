package com.growvity.growvity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growvity.growvity.globalException.BadRequestException;
import com.growvity.growvity.globalException.ResourceNotFoundException;
import com.growvity.growvity.model.Courses;
import com.growvity.growvity.repo.CoursesRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CoursesService {

    private final CoursesRepo coursesRepo;

    public List<Courses> getAllCourses(){
        return coursesRepo.findAll();
    }

    public Courses getCourse(Long id){
        return coursesRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Course not found with id: " + id));
    }

    public Courses saveCourse(Courses course){

        if(course.getTitle() == null || course.getTitle().isEmpty()){
            throw new BadRequestException("Course title cannot be empty");
        }

        return coursesRepo.save(course);
    }

    public Courses updateCourse(Long id, Courses updated){

        Courses course = getCourse(id);

        if(updated.getTitle() != null){
            course.setTitle(updated.getTitle());
        }

        if(updated.getPrice() != 0){
            course.setPrice(updated.getPrice());
        }

        return coursesRepo.save(course);
    }

    public void deleteCourse(Long id){
        Courses course = getCourse(id);
        coursesRepo.delete(course);
    }
}