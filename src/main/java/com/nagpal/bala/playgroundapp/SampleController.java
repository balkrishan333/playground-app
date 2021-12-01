package com.nagpal.bala.playgroundapp;

import com.nagpal.bala.playgroundapp.opentelemetry.OpenTelemetryFactory;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.*;
import io.opentelemetry.context.Context;
import io.opentelemetry.context.Scope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}