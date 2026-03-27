package com.growvity.growvity.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.growvity.growvity.model.Note;

public interface NoteRepo extends JpaRepository<Note, Long>{

}
