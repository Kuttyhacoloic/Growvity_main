package com.growvity.growvity.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class EnrollmentDTO {

    private Long id;
    private Long courseId;
    private Long studentId;
    private LocalDateTime enrolledAt;
    private String status;
}