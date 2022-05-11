package com.nagpal.bala.playgroundapp.graphql.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Table(name = "student")
@Entity
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @JoinColumn(name = "address_id")
    @OneToOne
    private Address address;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<Subject> learningSubjects;
}
