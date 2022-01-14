package com.example.todoapp.adapter;

import com.example.todoapp.model.Note;
import com.example.todoapp.model.NoteRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlNoteRepository extends NoteRepository, JpaRepository<Note, Integer> {
}
