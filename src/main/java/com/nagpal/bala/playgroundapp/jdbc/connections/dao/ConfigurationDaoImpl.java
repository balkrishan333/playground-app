package com.nagpal.bala.playgroundapp.jdbc.connections.dao;

import com.nagpal.bala.playgroundapp.jdbc.connections.model.Configuration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationDaoImpl implements ConfigurationDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Configuration save(Configuration configuration) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer) session.save(configuration);
        transaction.commit();
        configuration.setId(id);

        return configuration;
    }
}
