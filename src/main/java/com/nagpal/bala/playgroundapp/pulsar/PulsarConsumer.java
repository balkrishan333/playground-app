package com.nagpal.bala.playgroundapp.pulsar;

import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.PulsarClient;
import org.apache.pulsar.client.api.PulsarClientException;
import org.apache.pulsar.client.api.SubscriptionInitialPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class PulsarConsumer {

    @Autowired
    private PulsarAppClient appClient;

    public Consumer<byte[]> getConsumer(String topic) {

        Consumer<byte[]> consumer;
        PulsarClient pulsarClient = appClient.getPulsarClient();

        try {
            consumer = pulsarClient.newConsumer()
                    .topic(topic)
                    .subscriptionName("my-subscription")
                    .subscriptionInitialPosition(SubscriptionInitialPosition.Earliest)
                    .subscribe();

        } catch (PulsarClientException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }

        return consumer;
    }
}
