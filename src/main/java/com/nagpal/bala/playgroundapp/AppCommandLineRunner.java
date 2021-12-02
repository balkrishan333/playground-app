package com.nagpal.bala.playgroundapp;

import com.nagpal.bala.playgroundapp.pulsar.PulsarConsumer;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class AppCommandLineRunner implements CommandLineRunner {

    private static final String TOPIC = "topic1";
    @Autowired
    private PulsarConsumer pulsarConsumer;

    @Override
    public void run(String... args) {

        log.info("Retrieving message from topic: " + TOPIC);

        Consumer<byte[]> consumer = pulsarConsumer.getConsumer(TOPIC);
    }
}


