package com.nagpal.bala.playgroundapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SpringConfigTestController {

    private static final Logger log = LoggerFactory.getLogger(SpringConfigTestController.class);


    @Autowired
    private AppConfiguration appConfiguration;

    @RequestMapping(method = RequestMethod.GET, path = "/fetch-spring-config")
    public String hello() {
        Map<String, String> secrets = appConfiguration.getClientSecrets();
        System.out.println("secrets = " + secrets);
        return "Hello from server !!!";
    }
}