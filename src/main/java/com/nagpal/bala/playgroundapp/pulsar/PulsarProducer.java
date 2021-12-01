package com.nagpal.bala.playgroundapp.pulsar;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Producer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PulsarProducer {

    @Autowired
    private PulsarAppClient appClient;

    public Producer<byte[]> getProducer(String topic) {

        Producer<byte[]> producer;
        PulsarClient pulsarClient = appClient.getPulsarClient();

        try {
            producer = pulsarClient.newProducer()
                    .topic(topic)
                    .create();
        } catch (PulsarClientException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        return producer;
    }
}
