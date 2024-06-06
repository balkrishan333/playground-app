package com.nagpal.bala.playgroundapp.graphql.model;

import lombok.Data;

import jakarta.persistence.*;

@Data
@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "marks_obtained")
    private Double marksObtained;

    @Column(name = "subject_name")
    private String subjectName;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

}
