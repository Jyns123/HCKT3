package com.example.demo.controller;

import com.example.demo.model.Professor;
import com.example.demo.repository.ProfessorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorRepository repository;

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody Professor details) {
        return ResponseEntity.ok(repository.save(details));
    }

    @GetMapping
    public ResponseEntity<Iterable<Professor>> read() {
        return ResponseEntity.ok(repository.findAll());
    }
    
}