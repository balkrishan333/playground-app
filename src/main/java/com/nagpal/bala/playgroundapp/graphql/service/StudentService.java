package com.nagpal.bala.playgroundapp.graphql.service;

import com.nagpal.bala.playgroundapp.graphql.model.Address;
import com.nagpal.bala.playgroundapp.graphql.model.Student;
import com.nagpal.bala.playgroundapp.graphql.model.Subject;
import com.nagpal.bala.playgroundapp.graphql.repository.AddressRepository;
import com.nagpal.bala.playgroundapp.graphql.repository.StudentRepository;
import com.nagpal.bala.playgroundapp.graphql.repository.SubjectRepository;
import com.nagpal.bala.playgroundapp.graphql.request.CreateStudentRequest;
import com.nagpal.bala.playgroundapp.graphql.request.CreateSubjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    public Student getStudentById(Long id) {
       return studentRepository.findById(id).get();
    }

    public Student createStudent (CreateStudentRequest createStudentRequest) {
        Student student = new Student(createStudentRequest);

        Address address = new Address();
        address.setStreet(createStudentRequest.getStreet());
        address.setCity(createStudentRequest.getCity());

        address = addressRepository.save(address);

        student.setAddress(address);
        student = studentRepository.save(student);

        List<Subject> subjectsList = new ArrayList<Subject>();

        if(createStudentRequest.getSubjectsLearning() != null) {
            for (CreateSubjectRequest createSubjectRequest :
                    createStudentRequest.getSubjectsLearning()) {
                Subject subject = new Subject();
                subject.setSubjectName(createSubjectRequest.getSubjectName());
                subject.setMarksObtained(createSubjectRequest.getMarksObtained());
                subject.setStudent(student);

                subjectsList.add(subject);
            }

            subjectRepository.saveAll(subjectsList);

        }

        student.setLearningSubjects(subjectsList);

        return student;
    }
}
