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
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer credits;

    @OneToMany(mappedBy = "course")
    private List<CourseAssessment> courseAssessments;

    private String code;

    private String HRGroup;

    private String cycle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseType_id")
    private CourseType courseType;

    private String VRGroup;
}
