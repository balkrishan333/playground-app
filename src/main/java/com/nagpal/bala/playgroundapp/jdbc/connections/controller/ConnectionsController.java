package com.nagpal.bala.playgroundapp.jdbc.connections.controller;

import com.nagpal.bala.playgroundapp.jdbc.connections.model.Configuration;
import com.nagpal.bala.playgroundapp.jdbc.connections.model.Message;
import com.nagpal.bala.playgroundapp.jdbc.connections.service.ConfigurationService;
import com.nagpal.bala.playgroundapp.jdbc.connections.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectionsController {

    @Autowired
    private MessageService messageService;
    @Autowired
    private ConfigurationService configurationService;

    @RequestMapping(method = RequestMethod.POST, value = "/message", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createMessage(@RequestBody Message message) {
        Message saved = messageService.save(message);
        return "Message saved. Id : " + saved.getId();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/configuration", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String createConfiguration(@RequestBody Configuration configuration) {
        Configuration saved = configurationService.save(configuration);
        return "Configuration saved. Id : " + saved.getId();
    }
}
