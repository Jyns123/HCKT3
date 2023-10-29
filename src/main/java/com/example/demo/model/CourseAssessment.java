package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CourseAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "periodo_id")
    private Periodo periodo;

    private String title;

    private String tipoNota;

    private String numNota;

    private String nomenclatura;

    @OneToMany(mappedBy = "courseAssessment")
    private List<CourseAssessmentDetails> courseAssessmentDetails;

}