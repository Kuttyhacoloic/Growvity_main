package com.growvity.growvity.ApiResponse;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {

  
    private String message;
    private T data;
    private boolean success;

}