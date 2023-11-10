package com.example.demo.controller;

import com.example.demo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student details) {
        return ResponseEntity.ok(studentRepository.save(details));
    }
    @GetMapping
    public ResponseEntity<Iterable<Student>> read() {
        return ResponseEntity.ok(studentRepository.findAll());
    }
}