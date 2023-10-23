package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CourseAssessmentDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String score;
    private String section;
    private String sectionGroup;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private CourseAssessment courseAssessment;

    // Getters, Setters, y otros métodos pertinentes
}
