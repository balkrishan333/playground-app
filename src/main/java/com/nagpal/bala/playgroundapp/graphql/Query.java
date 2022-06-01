package com.nagpal.bala.playgroundapp.graphql;

import com.nagpal.bala.playgroundapp.graphql.response.StudentResponse;
import com.nagpal.bala.playgroundapp.graphql.service.StudentService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
/*
    Each method will be a GraphQL operation if an entry for that method exists in GraphQL schema
 */
public class Query implements GraphQLQueryResolver {

    @Autowired
    private StudentService studentService;

    public String firstQuery() {
        return "First Query";
    }

    public String fullName(String firstName, String lastName) {
        return firstName + " " + lastName;
    }

    public String fullNameJSON(SampleRequest sampleRequest) {
        return sampleRequest.getFirstName() + " " + sampleRequest.getLastName();
    }

    public StudentResponse getStudent(Long id) {
        return new StudentResponse(studentService.getStudentById(id));
    }
}
