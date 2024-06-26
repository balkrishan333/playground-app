package com.nagpal.bala.playgroundapp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties
@Getter
@Setter
@ToString
public class AppConfiguration {

    private Map<String, String> clientSecrets;

    private String fileUploadPath;

    private String pulsarURL;
}
