package com.nagpal.bala.playgroundapp.graphql.repository;

import com.nagpal.bala.playgroundapp.graphql.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
