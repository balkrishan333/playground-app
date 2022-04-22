package com.nagpal.bala.playgroundapp.jdbc.connections.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Configuration {

    @Id @GeneratedValue
    private int id;
    private String key;
    private String value;
}
