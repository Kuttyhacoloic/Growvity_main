package com.growvity.growvity.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MessageDTO {

	private Long id;
    private Long senderId;
    private Long receiverId;
    private String subject;
    private String messageBody;
    private Boolean isRead;
    private LocalDateTime sentAt;
}
