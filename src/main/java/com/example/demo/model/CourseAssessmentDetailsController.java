package com.example.demo.model;

import com.example.demo.repository.CourseAssessmentDetailsRepository;
import com.example.demo.repository.CourseAssessmentRepository;
import com.example.demo.repository.ProfessorRepository;
import com.example.demo.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/course_assessment_details")
public class CourseAssessmentDetailsController {

    @Autowired
    private CourseAssessmentDetailsRepository repository;
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private CourseAssessmentRepository courseAssessmentRepository;

    @GetMapping
    public ResponseEntity<List<CourseAssessmentDetails>> getAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseAssessmentDetails> getById(@PathVariable Long id) {
        Optional<CourseAssessmentDetails> details = repository.findById(id);
        if (details.isPresent()) {
            return ResponseEntity.ok(details.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<CourseAssessmentDetails> create(@RequestBody CourseAssessmentDetails details) {
    Optional<Student> optionalStudent = studentRepository.findById(details.getStudent().getId());
    if (!optionalStudent.isPresent()) {
        return ResponseEntity.badRequest().body(null);
    }
    details.setStudent(optionalStudent.get());

    Optional<Professor> optionalProfessor = professorRepository.findById(details.getProfessor().getId());
    if (!optionalProfessor.isPresent()) {
        return ResponseEntity.badRequest().body(null);
    }
    details.setProfessor(optionalProfessor.get());

    Optional<CourseAssessment> optionalCourseAssessment = courseAssessmentRepository.findById(details.getCourseAssessment().getId());
    if (!optionalCourseAssessment.isPresent()) {
        return ResponseEntity.badRequest().body(null);
    }
    details.setCourseAssessment(optionalCourseAssessment.get());

    return ResponseEntity.ok(repository.save(details));
}

    @PutMapping("/{id}")
    public ResponseEntity<CourseAssessmentDetails> update(@PathVariable Long id, @RequestBody CourseAssessmentDetails details) {
        if (repository.existsById(id)) {
            details.setId(id);
            return ResponseEntity.ok(repository.save(details));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
