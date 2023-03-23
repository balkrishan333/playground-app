package com.nagpal.bala.playgroundapp.azure.servicebus;

import com.azure.core.amqp.AmqpTransportType;
import com.azure.core.util.BinaryData;
import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusMessageBatch;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import com.azure.messaging.servicebus.models.CreateMessageBatchOptions;

import java.util.Arrays;
import java.util.List;

public class ServiceBusProducer {

    public static final String CONNECTION_STRING = System.getenv("AZURE_SERVICEBUS_NAMESPACE_CONNECTION_STRING");
    public static final String TOPIC_NAME = "balatopic";

    public static void main(String[] args) {
        ServiceBusProducer producer = new ServiceBusProducer();
        producer.send(String.valueOf(System.currentTimeMillis())+"-bala");
    }

    public void send(String message) {

        System.out.println("Connection String: " + CONNECTION_STRING);
        ServiceBusSenderClient client =
                new ServiceBusClientBuilder().connectionString(CONNECTION_STRING).transportType(AmqpTransportType.AMQP_WEB_SOCKETS)
                        .sender().topicName(TOPIC_NAME).buildClient();

        ServiceBusMessage busMessage = new ServiceBusMessage(message);
        client.sendMessage(busMessage);

        System.out.println("Message sent.");
        client.close();
      //  run();
    }

    public void run() {
        List<ServiceBusMessage> testMessages = Arrays.asList(
                new ServiceBusMessage(BinaryData.fromString("Green")),
                new ServiceBusMessage(BinaryData.fromString("Red")),
                new ServiceBusMessage(BinaryData.fromString("Blue")),
                new ServiceBusMessage(BinaryData.fromString("Orange")));

        // Instantiate a client that will be used to call the service.
        ServiceBusSenderClient sender = new ServiceBusClientBuilder()
                .connectionString(CONNECTION_STRING)
                .sender()
                .topicName(TOPIC_NAME)
                .buildClient();

        // Creates an ServiceBusMessageBatch where the ServiceBus.
        // If no maximumSizeInBatch is set, the maximum message size is used.
        ServiceBusMessageBatch currentBatch = sender.createMessageBatch(
                new CreateMessageBatchOptions().setMaximumSizeInBytes(1024));

        // We try to add as many messages as a batch can fit based on the maximum size and send to Service Bus when
        // the batch can hold no more messages. Create a new batch for next set of messages and repeat until all
        // messages are sent.
        for (ServiceBusMessage message : testMessages) {
            if (currentBatch.tryAddMessage(message)) {
                continue;
            }

            // The batch is full, so we create a new batch and send the batch.
            sender.sendMessages(currentBatch);
            currentBatch = sender.createMessageBatch();

            // Add that message that we couldn't before.
            if (!currentBatch.tryAddMessage(message)) {
                System.err.printf("Message is too large for an empty batch. Skipping. Max size: %s. Message: %s%n",
                        currentBatch.getMaxSizeInBytes(), message.getBody().toString());
            }
        }

        sender.sendMessages(currentBatch);

        //close the client
        sender.close();
    }
}
