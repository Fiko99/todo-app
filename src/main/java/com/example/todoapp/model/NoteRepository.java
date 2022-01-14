package com.example.todoapp.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {
    List<Note> findAll();

    Optional<Note> findById(Integer id);

    Note save(Note entity);

    Page<Note> findAll(Pageable pageable);

    //List<Note> findByDone(@Param("state") boolean done);

    boolean existsById(Integer id);

    void deleteById(Integer id);
}
