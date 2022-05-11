package com.nagpal.bala.playgroundapp.graphql.repository;

import com.nagpal.bala.playgroundapp.graphql.model.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
