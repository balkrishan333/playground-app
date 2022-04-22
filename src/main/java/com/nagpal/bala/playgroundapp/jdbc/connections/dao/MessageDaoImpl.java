package com.nagpal.bala.playgroundapp.jdbc.connections.dao;

import com.nagpal.bala.playgroundapp.jdbc.connections.model.Message;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageDaoImpl implements MessageDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Message save(Message message) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        Integer id = (Integer)session.save(message);
        transaction.commit();

        message.setId(id);
        return message;
    }
}
