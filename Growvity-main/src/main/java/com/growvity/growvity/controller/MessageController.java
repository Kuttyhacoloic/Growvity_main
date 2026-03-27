package com.growvity.growvity.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.growvity.growvity.ApiResponse.ApiResponse;
import com.growvity.growvity.model.Message;
import com.growvity.growvity.service.MessageService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Message>>> getAllMessages(){
    	

        List<Message> messages = messageService.getAllMessages();

        return ResponseEntity.ok(
                new ApiResponse<>("Messages fetched successfully", messages, true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Message>> getMessage(@PathVariable Long id){

        Message message = messageService.getMessage(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Message found", message, true));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Message>> sendMessage(@RequestBody Message message){

        Message saved = messageService.saveMessage(message);

        return ResponseEntity.ok(
                new ApiResponse<>("Message sent successfully", saved, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Message>> updateMessage(
            @PathVariable Long id,
            @RequestBody Message message){

        Message updated = messageService.updateMessage(id, message);

        return ResponseEntity.ok(
                new ApiResponse<>("Message updated successfully", updated, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteMessage(@PathVariable Long id){

        messageService.deleteMessage(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Message deleted successfully", null, true));
    }
}