package com.nagpal.bala.playgroundapp.jdbc.connections.repository;

import com.nagpal.bala.playgroundapp.jdbc.connections.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {
}
