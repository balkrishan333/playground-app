package com.nagpal.bala.playgroundapp.graphql.client;

import com.nagpal.bala.playgroundapp.graphql.request.CreateStudentRequest;
import com.nagpal.bala.playgroundapp.graphql.response.StudentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{id}")
    public StudentResponse getStudentById(@PathVariable Integer id) {
        return clientService.getStudentById(id);
    }

    @PostMapping("/create")
    public StudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        return clientService.createStudent(createStudentRequest);
    }
}
