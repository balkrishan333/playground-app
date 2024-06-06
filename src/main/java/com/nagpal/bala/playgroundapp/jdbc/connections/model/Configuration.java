package com.nagpal.bala.playgroundapp.jdbc.connections.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Configuration {

    @Id
    @GeneratedValue
    private int id;
    private String key;
    private String value;
}
