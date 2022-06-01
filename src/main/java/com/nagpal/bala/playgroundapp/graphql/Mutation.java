package com.nagpal.bala.playgroundapp.graphql;

import com.nagpal.bala.playgroundapp.graphql.request.CreateStudentRequest;
import com.nagpal.bala.playgroundapp.graphql.response.StudentResponse;
import com.nagpal.bala.playgroundapp.graphql.service.StudentService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private StudentService studentService;

    public StudentResponse createStudent(CreateStudentRequest request) {
       return new StudentResponse(studentService.createStudent(request));
    }
}
