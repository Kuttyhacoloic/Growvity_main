package com.growvity.growvity.ApiResponse;

import com.growvity.growvity.globalException.GlobalExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionResponse<T> extends GlobalExceptionHandler {

	private String message;
	private T data;
	private Boolean Status;
	
}
