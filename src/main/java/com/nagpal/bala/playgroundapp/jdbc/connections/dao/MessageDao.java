package com.nagpal.bala.playgroundapp.jdbc.connections.dao;

import com.nagpal.bala.playgroundapp.jdbc.connections.model.Message;

public interface MessageDao {

    Message save(Message message);
}
