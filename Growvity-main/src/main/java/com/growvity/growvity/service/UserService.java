package com.growvity.growvity.service;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growvity.growvity.globalException.BadRequestException;
import com.growvity.growvity.globalException.ResourceNotFoundException;
import com.growvity.growvity.model.User;
import com.growvity.growvity.repo.UserRepo;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }

    public User getUser(Long id){
        return userRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));
    }

    public User registerUser(User user){

        if(user.getEmail() == null || user.getEmail().isEmpty()){
            throw new BadRequestException("Email cannot be empty");
        }

        if(userRepo.existsByEmail(user.getEmail())){
            throw new BadRequestException("Email already exists");
        }

        return userRepo.save(user);
    }

    public User updateUser(Long id, User updatedUser){

        User existing = getUser(id);

        if(updatedUser.getUserName() != null){
            existing.setUserName(updatedUser.getUserName());
        }

        if(updatedUser.getEmail() != null){

            if(userRepo.existsByEmail(updatedUser.getEmail()) &&
                    !existing.getEmail().equals(updatedUser.getEmail())){
                throw new BadRequestException("Email already in use");
            }

            existing.setEmail(updatedUser.getEmail());
        }

        return userRepo.save(existing);
    }

    public void deleteUser(Long id){
        User user = getUser(id);
        userRepo.delete(user);
    }
}