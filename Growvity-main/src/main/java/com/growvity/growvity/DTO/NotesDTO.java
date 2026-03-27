package com.growvity.growvity.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class NotesDTO {

	private Long id;
    private Long courseId;
    private Long uploadedBy;
    private String title;
    private String fileUrl;
    private LocalDateTime uploadedAt;
}
