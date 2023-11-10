package com.example.demo.controller;

import com.example.demo.model.CourseType;
import com.example.demo.repository.CourseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coursetype")
public class CourseTypeController {

    @Autowired
    private CourseTypeRepository courseTypeRepository;

    @PostMapping
    public ResponseEntity<CourseType> create(@RequestBody CourseType details) {
        return ResponseEntity.ok(courseTypeRepository.save(details));
    }

    @GetMapping
    public ResponseEntity<Iterable<CourseType>> read() {
        return ResponseEntity.ok(courseTypeRepository.findAll());
    }

}
