package com.nagpal.bala.playgroundapp.graphql.response;

import com.nagpal.bala.playgroundapp.graphql.model.Subject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectResponse {

	private Long id;
	private String subjectName;
	private Double marksObtained;
	public SubjectResponse (Subject subject) {
		this.id = subject.getId();
		this.subjectName = subject.getSubjectName();
		this.marksObtained = subject.getMarksObtained();
	}
}
