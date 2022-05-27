package com.nagpal.bala.playgroundapp.graphql;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.nagpal.bala.playgroundapp.graphql.model.Student;
import com.nagpal.bala.playgroundapp.graphql.model.Subject;
import com.nagpal.bala.playgroundapp.graphql.response.StudentResponse;
import com.nagpal.bala.playgroundapp.graphql.response.SubjectResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentResponseResolver implements GraphQLResolver<StudentResponse> {

    public List<SubjectResponse> getLearningSubjects(StudentResponse studentResponse) {

        List<SubjectResponse> learningSubjects = new ArrayList<>();
        Student student = studentResponse.getStudent();

        for (Subject subject: student.getLearningSubjects()) {
            learningSubjects.add(new SubjectResponse(subject));
        }
        return learningSubjects;
    }
}
