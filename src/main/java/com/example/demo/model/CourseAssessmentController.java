package com.example.demo.model;

import com.example.demo.repository.CourseAssessmentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/course_assessment")
public class CourseAssessmentController {

    @Autowired
    private CourseAssessmentRepository repository;

    @PostMapping
    public ResponseEntity<CourseAssessment> create(@RequestBody CourseAssessment details) {
        return ResponseEntity.ok(repository.save(details));
    }

    @GetMapping
    public ResponseEntity<Iterable<CourseAssessment>> read() {
        return ResponseEntity.ok(repository.findAll());
    }
}