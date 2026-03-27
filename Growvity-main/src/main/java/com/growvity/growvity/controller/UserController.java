package com.growvity.growvity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.growvity.growvity.ApiResponse.ApiResponse;
import com.growvity.growvity.model.User;
import com.growvity.growvity.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // GET ALL USERS
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<User>>> getAllUsers(){

        List<User> users = userService.getAllUsers();

        return ResponseEntity.ok(
                new ApiResponse<>("Users fetched successfully", users, true)
        );
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> getUserById(@PathVariable Long id){

        User user = userService.getUser(id);

        return ResponseEntity.ok(
                new ApiResponse<>("User found", user, true)
        );
    }

    // REGISTER USER
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<User>> registerUser(@RequestBody User user){

        User savedUser = userService.registerUser(user);

        return ResponseEntity.ok(
                new ApiResponse<>("User registered successfully", savedUser, true)
        );
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<User>> updateUser(
            @PathVariable Long id,
            @RequestBody User user){

        User updatedUser = userService.updateUser(id, user);

        return ResponseEntity.ok(
                new ApiResponse<>("User updated successfully", updatedUser, true)
        );
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<ApiResponse<User>> deleteUser(@PathVariable Long id){
    		userService.deleteUser(id);
    		
    		return ResponseEntity.ok(new ApiResponse<>("User Deleted successfully",null,true)
    				);
    	
    }
    
}