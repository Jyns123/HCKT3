package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;

    @PostMapping
    public ResponseEntity<Course> create(@RequestBody Course details) {
        return ResponseEntity.ok(courseRepository.save(details));
    }

    @GetMapping
    public ResponseEntity<Iterable<Course>> read() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

}