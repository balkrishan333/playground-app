package com.nagpal.bala.playgroundapp;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Log4j2
public class SpringConfigTestController {

    @Autowired
    private AppConfiguration appConfiguration;

    @RequestMapping(method = RequestMethod.GET, path = "/fetch-spring-config")
    public ResponseEntity<String> hello() {
        log.info("Fetching spring configuration...");
        Map<String, String> secrets = appConfiguration.getClientSecrets();
        log.info("appConfiguration = {}", appConfiguration);
        return ResponseEntity.ok(secrets.toString());
    }
}