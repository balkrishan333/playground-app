package com.nagpal.bala.playgroundapp.graphql.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @OneToOne(mappedBy = "address")
    private Student student;
}
