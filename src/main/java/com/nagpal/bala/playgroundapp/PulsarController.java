package com.nagpal.bala.playgroundapp;

import com.nagpal.bala.playgroundapp.pulsar.PulsarConsumer;
import com.nagpal.bala.playgroundapp.pulsar.PulsarProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.pulsar.client.api.Consumer;
import org.apache.pulsar.client.api.Message;
import org.apache.pulsar.client.api.MessageId;
import org.apache.pulsar.client.api.PulsarClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public final class PulsarController {

    @Autowired
    private PulsarProducer pulsarProducer;
    @Autowired
    private PulsarConsumer pulsarConsumer;

    @GetMapping(path = "/pulsar/publish/{topic}")
    public ResponseEntity<String> publish(@PathVariable String topic, @RequestParam String message) {
        log.info("Sending message to pulsar topic : " + topic);
        log.info("Message: " + message);

        MessageId messageId;
        try {
            messageId = pulsarProducer.getProducer(topic).send(message.getBytes());
        } catch (PulsarClientException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

        return ResponseEntity.ok("Message published. Message id: " + messageId);
    }

    @GetMapping(path = "/pulsar/consume/{topic}")
    public ResponseEntity<String> consume(@PathVariable String topic) {

        log.info("Retrieving message from topic: " + topic);

        Consumer<byte[]> consumer = pulsarConsumer.getConsumer(topic);
        Message<byte[]> message;
        try {
            message = consumer.receive();
        } catch (PulsarClientException e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(e.getMessage());
        }

        log.info("Message received from pulsar");

        try {
            consumer.acknowledge(message.getMessageId());
            consumer.close();
        } catch (PulsarClientException e) {
            log.error(e.getMessage());
        }
        return ResponseEntity.ok(new String(message.getData()));
    }
}
