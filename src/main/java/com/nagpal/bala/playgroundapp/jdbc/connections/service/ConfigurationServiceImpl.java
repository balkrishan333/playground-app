package com.nagpal.bala.playgroundapp.jdbc.connections.service;

import com.nagpal.bala.playgroundapp.jdbc.connections.dao.ConfigurationDao;
import com.nagpal.bala.playgroundapp.jdbc.connections.model.Configuration;
import com.nagpal.bala.playgroundapp.jdbc.connections.repository.ConfigurationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ConfigurationServiceImpl implements ConfigurationService {

    @Autowired
    private ConfigurationRepository configurationRepository;
    @Autowired
    private ConfigurationDao configurationDao;

    @Override
    @Transactional
    public Configuration save(Configuration configuration) {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return configurationRepository.save(configuration);
//        return configurationDao.save(configuration);
    }

    @Override
    public boolean delete(Configuration message) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
