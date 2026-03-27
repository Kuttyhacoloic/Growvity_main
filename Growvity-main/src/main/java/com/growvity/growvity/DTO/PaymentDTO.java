package com.growvity.growvity.DTO;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PaymentDTO {

	 private Long id;
	    private Long studentId;
	    private Long courseId;
	    private Double amount;
	    private LocalDateTime paymentDate;
	    private String paymentStatus;
	    private String transactionId;
	    private String paymentMethod;
}
