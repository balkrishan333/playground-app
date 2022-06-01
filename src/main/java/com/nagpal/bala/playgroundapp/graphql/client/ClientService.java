package com.nagpal.bala.playgroundapp.graphql.client;

import com.nagpal.bala.playgroundapp.graphql.request.CreateStudentRequest;
import com.nagpal.bala.playgroundapp.graphql.response.StudentResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLRequest;
import graphql.kickstart.spring.webclient.boot.GraphQLResponse;
import graphql.kickstart.spring.webclient.boot.GraphQLWebClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ClientService {

    @Autowired
    private GraphQLWebClient graphQLWebClient;

    public StudentResponse getStudentById(Integer id) {
        Map<String, Object> variables = new HashMap<>();
        variables.put("id", id);

        String query = "query student($id : Int) {\n" +
                "  student(id: $id ) {\n" +
                "    id\n" +
                "    firstName\n" +
                "    lastName\n" +
                "    email\n" +
                "    street\n" +
                "    city\n" +
                "    learningSubjects(subjectNameFilter: [\"Java\"]) {\n" +
                "      id\n" +
                "      subjectName\n" +
                "      marksObtained\n" +
                "    }\n" +
                "  }\n" +
                "}";

        GraphQLRequest request = GraphQLRequest.builder().query(query).variables(variables).build();
        GraphQLResponse response = graphQLWebClient.post(request).block();
        return response.get("student", StudentResponse.class);
    }

    public StudentResponse createStudent(CreateStudentRequest request) {

        Map<String, Object> variables = new HashMap<>();
        variables.put("request", request);

        String mutation = "mutation createStudent($request : CreateStudentRequest) {\n" +
                "  createStudent(createStudentRequest: $request) {\n" +
                "    id\n" +
                "    firstName\n" +
                "    lastName\n" +
                "    email\n" +
                "    street\n" +
                "    city\n" +
                "    learningSubjects(subjectNameFilter: [\"Java\"]) {\n" +
                "      id\n" +
                "      subjectName\n" +
                "      marksObtained\n" +
                "    }\n" +
                "  }\n" +
                "}\n";

        GraphQLRequest graphQLRequest = GraphQLRequest.builder().query(mutation).variables(variables).build();
        GraphQLResponse response = graphQLWebClient.post(graphQLRequest).block();
        return response.get("createStudent", StudentResponse.class);
    }
}


