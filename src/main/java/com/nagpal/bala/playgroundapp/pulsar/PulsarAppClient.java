package com.nagpal.bala.playgroundapp.pulsar;

import com.nagpal.bala.playgroundapp.AppConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*
    Responsible for connecting to pulsar and returns client which can be used by producer and consumer
    to send and receive messages.
 */
@Component
@Slf4j
public final class PulsarAppClient {

    @Autowired
    private AppConfiguration appConfiguration;

    private static PulsarClient client;

    public PulsarClient getPulsarClient() {

        if (client != null) {
            return client;
        }

        try {
            client = PulsarClient.builder()
                    .serviceUrl(appConfiguration.getPulsarURL())
                    .build();

            log.info("Pulsar client connection acquired...");
        } catch (PulsarClientException e) {
            log.error("Can't connect to pulsar. Client initialization failed.");
            throw new RuntimeException(e);
        }
        return client;
    }
}
