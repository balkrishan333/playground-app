package com.nagpal.bala.playgroundapp.jdbc.connections.repository;

import com.nagpal.bala.playgroundapp.jdbc.connections.model.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigurationRepository extends JpaRepository<Configuration, Integer> {
}
