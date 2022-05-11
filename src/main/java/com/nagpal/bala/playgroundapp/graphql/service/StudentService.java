package com.nagpal.bala.playgroundapp.graphql.service;

import com.nagpal.bala.playgroundapp.graphql.model.Student;
import com.nagpal.bala.playgroundapp.graphql.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(Long id) {
       return studentRepository.findById(id).get();
    }
}
