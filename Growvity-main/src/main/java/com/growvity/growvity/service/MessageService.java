package com.growvity.growvity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growvity.growvity.globalException.BadRequestException;
import com.growvity.growvity.globalException.ResourceNotFoundException;
import com.growvity.growvity.model.Message;
import com.growvity.growvity.repo.MessageRepo;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepo messageRepo;

    public List<Message> getAllMessages(){
        return messageRepo.findAll();
    }

    public Message getMessage(Long id){
        return messageRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Message not found with id: " + id));
    }

    public Message saveMessage(Message message){

        if(message.getSender() == null || message.getReceiver() == null){
            throw new BadRequestException("Sender and Receiver are required");
        }

        return messageRepo.save(message);
    }

    public Message updateMessage(Long id, Message updated){

        Message existing = getMessage(id);

        if(updated.getMessageBody() != null){
            existing.setMessageBody(updated.getMessageBody());
        }

        return messageRepo.save(existing);
    }

    public void deleteMessage(Long id){
        Message message = getMessage(id);
        messageRepo.delete(message);
    }
}