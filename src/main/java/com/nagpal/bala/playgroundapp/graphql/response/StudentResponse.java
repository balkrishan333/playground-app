package com.nagpal.bala.playgroundapp.graphql.response;

import java.util.ArrayList;
import java.util.List;

import com.nagpal.bala.playgroundapp.graphql.model.Student;
import com.nagpal.bala.playgroundapp.graphql.model.Subject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StudentResponse {

	private long id;
	private String firstName;
	private String lastName;
	private String email;
	private String street;
	private String city;
	private List<SubjectResponse> learningSubjects;

	//This is not exposed in schema as this is only required for resolver
	private Student student;
	
	public StudentResponse (Student student) {
		this.student = student;
		this.id = student.getId();
		this.firstName = student.getFirstName();
		this.lastName = student.getLastName();
		this.email = student.getEmail();
		
		this.street = student.getAddress().getStreet();
		this.city = student.getAddress().getCity();

		//This is moved to resolver, and resolver will be filling data
		/*if (student.getLearningSubjects() != null) {
			learningSubjects = new ArrayList<>();
			for (Subject subject: student.getLearningSubjects()) {
				learningSubjects.add(new SubjectResponse(subject));
			}
		}*/
	}

}
