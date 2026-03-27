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
import com.growvity.growvity.model.Note;
import com.growvity.growvity.service.NoteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<Note>>> getAllNotes(){

        List<Note> notes = noteService.getAllNotes();

        return ResponseEntity.ok(
                new ApiResponse<>("Notes fetched successfully", notes, true));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<ApiResponse<Note>> getNote(@PathVariable Long id){

        Note note = noteService.getNote(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Note found", note, true));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<Note>> createNote(@RequestBody Note note){

        Note saved = noteService.saveNote(note);

        return ResponseEntity.ok(
                new ApiResponse<>("Note created successfully", saved, true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Note>> updateNote(
            @PathVariable Long id,
            @RequestBody Note note){

        Note updated = noteService.updateNote(id, note);

        return ResponseEntity.ok(
                new ApiResponse<>("Note updated successfully", updated, true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteNote(@PathVariable Long id){

        noteService.deleteNote(id);

        return ResponseEntity.ok(
                new ApiResponse<>("Note deleted successfully", null, true));
    }
}