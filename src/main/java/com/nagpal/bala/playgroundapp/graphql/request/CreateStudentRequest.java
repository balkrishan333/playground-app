package com.nagpal.bala.playgroundapp.graphql.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CreateStudentRequest {

    private String firstName;
    private String lastName;
    private String street;
    private String email;
    private String city;
    private List<CreateSubjectRequest> subjectsLearning;
}
