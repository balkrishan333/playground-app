package com.nagpal.bala.playgroundapp.jdbc.connections.service;

import com.nagpal.bala.playgroundapp.jdbc.connections.dao.MessageDao;
import com.nagpal.bala.playgroundapp.jdbc.connections.model.Configuration;
import com.nagpal.bala.playgroundapp.jdbc.connections.model.Message;
import com.nagpal.bala.playgroundapp.jdbc.connections.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private MessageDao messageDao;
    @Autowired
    private ConfigurationService configurationService;

    @Override
    @Transactional
    public Message save(Message message) {
        Configuration configuration = new Configuration();
        configuration.setKey(message.getMessageType());
        configuration.setValue(message.getConfigValue());
        configurationService.save(configuration);

        return messageRepository.save(message);
//        return messageDao.save(message);
    }

    @Override
    public boolean delete(Message message) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
