package com.nagpal.bala.playgroundapp.jdbc.connections.service;

import com.nagpal.bala.playgroundapp.jdbc.connections.model.Message;

public interface MessageService {

    public Message save(Message message);

    public boolean delete(Message message);

    public boolean delete(int id);
}
