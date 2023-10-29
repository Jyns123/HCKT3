package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "student")
public class CourseAssessmentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String score;

    private String section;

    @ManyToOne
    @JoinColumn(name =  "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name =  "professor_id")
    private Professor professor;

    @ManyToOne
    @JoinColumn(name =  "course_assessment_id")
    private CourseAssessment courseAssessment;

    private String sectionGroup;
}
