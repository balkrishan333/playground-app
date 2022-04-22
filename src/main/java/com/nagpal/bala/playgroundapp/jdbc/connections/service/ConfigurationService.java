package com.nagpal.bala.playgroundapp.jdbc.connections.service;

import com.nagpal.bala.playgroundapp.jdbc.connections.model.Configuration;

public interface ConfigurationService {

    public Configuration save(Configuration message);

    public boolean delete(Configuration message);

    public boolean delete(int id);
}
