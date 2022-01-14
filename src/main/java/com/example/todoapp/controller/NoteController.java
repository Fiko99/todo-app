package com.example.todoapp.controller;

import com.example.todoapp.model.Note;
import com.example.todoapp.model.NoteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
public class NoteController {

    public static final Logger logger = LoggerFactory.getLogger(TaskController.class);
    private final NoteRepository noteRepository;

    public NoteController(final NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @GetMapping(path = "/notes")
    ResponseEntity<?> readAllNotes() {
        logger.warn("Exposing all the notes!");
        return ResponseEntity.ok(noteRepository.findAll());
    }

    @GetMapping("/note/{id}")
    ResponseEntity<Note> readNote(@PathVariable int id) {
        return noteRepository.findById(id)
                .map(note -> ResponseEntity.ok(note))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/notes/{id}")
    ResponseEntity<?> updateNote(@PathVariable int id, @RequestBody @Valid Note toUpdate) {
        if (!noteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        toUpdate.setId(id);
        noteRepository.save(toUpdate);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/notes/add")
    ResponseEntity<Note> addNote(@RequestBody @Valid Note note) {
        Note result = noteRepository.save(note);
        return ResponseEntity.created(URI.create("/" + result.getId())).body(result);
    }

    @DeleteMapping("/note/delete/{id}")
    ResponseEntity<Note> deleteNote(@PathVariable int id) {
        if (!noteRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        noteRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
