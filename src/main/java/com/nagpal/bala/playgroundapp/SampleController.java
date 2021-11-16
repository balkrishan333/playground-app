package com.nagpal.bala.playgroundapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.ThreadContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class SampleController {

    private static final Logger log = LoggerFactory.getLogger(SampleController.class);


    @Autowired
    private AppConfiguration appConfiguration;

    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String hello() {
        Map<String, String> secrets = appConfiguration.getClientSecrets();
        System.out.println("secrets = " + secrets);
        return "Hello from server !!!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/tracing")
    public String tracing() {
        return tracing1();
    }

    private String tracing1() {
        return "tracing 1 : " + tracing2();
    }

    private String tracing2() {
        return "tracing 2";
    }
}