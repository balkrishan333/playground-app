package com.nagpal.bala.playgroundapp.graphql.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CreateSubjectRequest {

    private String subjectName;
    private Double marksObtained;
}
