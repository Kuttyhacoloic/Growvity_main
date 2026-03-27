package com.growvity.growvity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.growvity.growvity.globalException.BadRequestException;
import com.growvity.growvity.globalException.ResourceNotFoundException;
import com.growvity.growvity.model.Note;
import com.growvity.growvity.repo.NoteRepo;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class NoteService {

    private final NoteRepo noteRepo;

    public List<Note> getAllNotes(){
        return noteRepo.findAll();
    }

    public Note getNote(Long id){
        return noteRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Note not found with id: " + id));
    }

    public Note saveNote(Note note){

        if(note.getTitle() == null || note.getTitle().isEmpty()){
            throw new BadRequestException("Note title cannot be empty");
        }

        return noteRepo.save(note);
    }

    public Note updateNote(Long id, Note updated){

        Note existing = getNote(id);

        if(updated.getTitle() != null){
            existing.setTitle(updated.getTitle());
        }

        return noteRepo.save(existing);
    }

    public void deleteNote(Long id){
        Note note = getNote(id);
        noteRepo.delete(note);
    }
}