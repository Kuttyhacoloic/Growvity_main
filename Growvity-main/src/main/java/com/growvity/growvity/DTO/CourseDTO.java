package com.growvity.growvity.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CourseDTO {

    private Long id;
    private String title;
    private String description;
    private Double price;
    private Integer duration;
    private Boolean isPublished;
    private Long trainerId;
    private LocalDateTime createdAt;
    
}