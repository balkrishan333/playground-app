package com.nagpal.bala.playgroundapp.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Person implements Serializable {

    private String firstName;
    private String lastName;
    private String address;
    private String mobile;
    private int countryCode;
    private String city;
    private String state;
    private String country;
    private String email;
    private String gender;
}
