package com.nagpal.bala.playgroundapp.jdbc.connections.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Message {

    @Id
    @GeneratedValue
    private int id;
    private String messageType;
    private String configValue;
}
